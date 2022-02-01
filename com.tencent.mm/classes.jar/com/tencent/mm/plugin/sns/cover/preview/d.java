package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.cover.a.a;
import com.tencent.mm.plugin.sns.cover.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsInvalidView;", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "folded", "", "getFolded", "()Z", "setFolded", "(Z)V", "getLayoutId", "", "getType", "loadCover", "", "info", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverInfo;", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private boolean Qmf;
  private final String TAG;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307414);
    this.Qmf = true;
    this.TAG = "MicroMsg.SnsCoverInvalidView";
    AppMethodBeat.o(307414);
  }
  
  public final void a(b paramb) {}
  
  public final void etL()
  {
    AppMethodBeat.i(307443);
    Log.i(this.TAG, "[onPreOpen]");
    this.Qmf = false;
    AppMethodBeat.o(307443);
  }
  
  public final void etM() {}
  
  public final void etO() {}
  
  public final boolean getFolded()
  {
    return this.Qmf;
  }
  
  public final int getLayoutId()
  {
    return b.g.sns_cover_invalid_view;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void onDestroy() {}
  
  public final void onPause() {}
  
  public final void onPostClose()
  {
    AppMethodBeat.i(307455);
    Log.i(this.TAG, "[onPreClose]");
    this.Qmf = true;
    AppMethodBeat.o(307455);
  }
  
  public final void onResume() {}
  
  public final void setFolded(boolean paramBoolean)
  {
    this.Qmf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.d
 * JD-Core Version:    0.7.0.1
 */