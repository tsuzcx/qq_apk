package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.abe;
import com.tencent.mm.autogen.a.abe.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.record.model.w;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TranslateHelper$1
  extends IListener<abe>
{
  TranslateHelper$1(i parami, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(305285);
    this.__eventId = abe.class.getName().hashCode();
    AppMethodBeat.o(305285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.TranslateHelper.1
 * JD-Core Version:    0.7.0.1
 */