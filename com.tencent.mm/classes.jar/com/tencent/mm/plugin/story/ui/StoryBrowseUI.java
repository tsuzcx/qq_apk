package com.tencent.mm.plugin.story.ui;

import a.f.b.u.d;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.api.o.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
@com.tencent.mm.ui.base.a(3)
public final class StoryBrowseUI
  extends MMActivity
  implements g
{
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  public static final StoryBrowseUI.a sHj;
  private ImageView mBi;
  private int sHg;
  private int sHh;
  private StoryGalleryView sHi;
  
  static
  {
    AppMethodBeat.i(110000);
    sHj = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(110000);
  }
  
  private final void cFm()
  {
    AppMethodBeat.i(109999);
    Object localObject = i.sFa;
    i.cDo().cD(at.gV((Context)getContext()));
    localObject = i.sFa;
    i.cDo().cH(System.currentTimeMillis());
    localObject = i.sFa;
    i.cDp();
    localObject = com.tencent.mm.plugin.story.g.c.sEl;
    com.tencent.mm.plugin.story.g.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(109999);
  }
  
  public final void cbR()
  {
    AppMethodBeat.i(109997);
    cFm();
    AppMethodBeat.o(109997);
  }
  
  public final void cbS() {}
  
  public final void cbT()
  {
    AppMethodBeat.i(109998);
    cFm();
    AppMethodBeat.o(109998);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(109996);
    StoryGalleryView localStoryGalleryView = this.sHi;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      cFm();
    }
    AppMethodBeat.o(109996);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109992);
    ab.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.g.c.sEl;
    com.tencent.mm.plugin.story.g.c.cCC();
    paramBundle = com.tencent.mm.plugin.story.g.b.sDR;
    com.tencent.mm.plugin.story.g.b.cCC();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.jm(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.mBi = paramBundle;
    this.sHh = getIntent().getIntExtra("h_position", 0);
    this.sHg = getIntent().getIntExtra("v_position", 0);
    String str1 = getIntent().getStringExtra("username");
    u.d locald = new u.d();
    locald.BNq = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = i.sFa;
    String str3 = i.cDo().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_is_for_sns", false);
    boolean bool3 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    ab.i(TAG, "vPosition " + this.sHg);
    localObject = i.sFa;
    i.cDr();
    localObject = i.sFa;
    i.cDo().cD(at.gV((Context)getContext()));
    localObject = i.sFa;
    i.cDo().cI(0L);
    localObject = i.sFa;
    i.cDo().cK(0L);
    localObject = new u.d();
    ((u.d)localObject).BNq = o.a.czC().ms(l);
    if ((((u.d)localObject).BNq != null) && ((((u.d)localObject).BNq instanceof o)))
    {
      paramBundle = (o)((u.d)localObject).BNq;
      a.f.b.j.q(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.model.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.model.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.model.d.c))) {
        if (((com.tencent.mm.plugin.story.model.d.c)paramBundle).qLh)
        {
          paramBundle = m.a.sqY;
          if (!(((u.d)localObject).BNq instanceof com.tencent.mm.plugin.story.model.d.c)) {
            break label787;
          }
          this.sHi = new StoryGalleryView((Context)this, paramBundle, this.sHg, bool3, ((com.tencent.mm.plugin.story.model.d.c)((u.d)localObject).BNq).syo);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setForSns(bool2);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((u.d)localObject).BNq);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((g)this);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.sHg);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.sHi;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new StoryBrowseUI.b(this));
      }
      localRelativeLayout.addView((View)this.mBi, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.sHi;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.sHi;
      if (paramBundle == null) {
        break label1031;
      }
      paramBundle.post((Runnable)new StoryBrowseUI.c(this, locald, str1, (u.d)localObject));
      AppMethodBeat.o(109992);
      return;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      if (bo.isEqual(j.b.coK(), ((com.tencent.mm.plugin.story.model.d.c)paramBundle).username))
      {
        paramBundle = m.a.sqW;
        break;
      }
      paramBundle = m.a.sqX;
      break;
      paramBundle = m.a.sqT;
      break;
      label787:
      this.sHi = new StoryGalleryView((Context)this, paramBundle, this.sHg, bool3, null, 16);
      continue;
      if (!bo.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.model.j.svi;
        if (bo.isEqual(str1, j.b.coK()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.sHi = new StoryGalleryView((Context)this, m.a.sqU, 0, false, null, 28);
            ((u.d)localObject).BNq = paramBundle;
            continue;
          }
          this.sHi = new StoryGalleryView((Context)this, m.a.sqQ, 0, false, null, 28);
          ((u.d)localObject).BNq = str1;
          continue;
        }
      }
      if (!bo.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.model.j.svi;
        if (!bo.isEqual(str1, j.b.coK()))
        {
          this.sHi = new StoryGalleryView((Context)this, m.a.sqS, 0, false, null, 28);
          ((u.d)localObject).BNq = str1;
          continue;
        }
      }
      if ((ArrayList)locald.BNq != null)
      {
        this.sHi = new StoryGalleryView((Context)this, m.a.sqT, 0, false, null, 28);
        ((u.d)localObject).BNq = new ArrayList((Collection)locald.BNq);
      }
    }
    label1031:
    AppMethodBeat.o(109992);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(109995);
    ab.i(TAG, "onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    Object localObject = this.sHi;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.g.c.sEl;
    com.tencent.mm.plugin.story.g.c.onDestroy();
    AppMethodBeat.o(109995);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(109994);
    ab.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.sHi;
    if (localStoryGalleryView != null)
    {
      localStoryGalleryView.onPause();
      AppMethodBeat.o(109994);
      return;
    }
    AppMethodBeat.o(109994);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(109993);
    ab.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.sHi;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.sHi;
    if (localStoryGalleryView != null)
    {
      localStoryGalleryView.czg();
      AppMethodBeat.o(109993);
      return;
    }
    AppMethodBeat.o(109993);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */