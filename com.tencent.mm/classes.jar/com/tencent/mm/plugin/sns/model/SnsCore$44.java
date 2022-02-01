package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jh;
import com.tencent.mm.autogen.a.jh.a;
import com.tencent.mm.autogen.mmdata.rpt.gj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SnsCore$44
  extends IListener<jh>
{
  SnsCore$44(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309530);
    this.__eventId = jh.class.getName().hashCode();
    AppMethodBeat.o(309530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.44
 * JD-Core Version:    0.7.0.1
 */