package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.voicesearch.b;
import java.io.IOException;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment Aan;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33530);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.Aan = new AddressUI.AddressUIFragment();
      this.Aan.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.Aan).commit();
    }
    AppMethodBeat.o(33530);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */