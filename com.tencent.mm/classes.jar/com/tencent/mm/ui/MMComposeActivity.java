package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.ak;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.b.a.a;
import androidx.lifecycle.q;
import androidx.savedstate.d;
import androidx.savedstate.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/MMComposeActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MMComposeActivity
  extends MMActivity
{
  public void _$_clearFindViewByIdCache() {}
  
  public void onCreate(Bundle paramBundle)
  {
    View localView = getWindow().getDecorView();
    s.s(localView, "window.decorView");
    if (al.be(localView) == null) {
      al.a(localView, (q)this);
    }
    ak localak1 = (ak)localView.getTag(a.a.view_tree_view_model_store_owner);
    ak localak2 = localak1;
    if (localak1 == null) {
      for (Object localObject = localView.getParent();; localObject = ((View)localObject).getParent())
      {
        localak2 = localak1;
        if (localak1 != null) {
          break;
        }
        localak2 = localak1;
        if (!(localObject instanceof View)) {
          break;
        }
        localObject = (View)localObject;
        localak1 = (ak)((View)localObject).getTag(a.a.view_tree_view_model_store_owner);
      }
    }
    if (localak2 == null) {
      am.a(localView, (ak)this);
    }
    if (e.bP(localView) == null) {
      e.b(localView, (d)this);
    }
    super.onCreate(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMComposeActivity
 * JD-Core Version:    0.7.0.1
 */