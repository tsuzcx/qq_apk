package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputBehavior
  extends com.tencent.mm.cd.a
{
  public int cancel;
  public int chooseArea;
  public int chooseCantonese;
  public int clear;
  public int click;
  public int fail;
  public int fullScreenVoiceLongClick;
  public long fullScreenVoiceLongClickTime;
  public long initChoose;
  public int longClick;
  public long longClickTime;
  public int send;
  public int setDefaultLanguage;
  public int setSwitchCantonese;
  public int setlanguage;
  public int showInit;
  public int smileIconClick;
  public int textChangeCount;
  public int textChangeReturn;
  public long textChangeTime;
  public int textClick;
  public int voiceIconClick;
  public long voiceInputTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.cancel);
      paramVarArgs.aY(2, this.send);
      paramVarArgs.aY(3, this.click);
      paramVarArgs.aY(4, this.longClick);
      paramVarArgs.bm(5, this.longClickTime);
      paramVarArgs.aY(6, this.textClick);
      paramVarArgs.aY(7, this.textChangeCount);
      paramVarArgs.bm(8, this.textChangeTime);
      paramVarArgs.aY(9, this.textChangeReturn);
      paramVarArgs.bm(10, this.voiceInputTime);
      paramVarArgs.aY(11, this.fail);
      paramVarArgs.aY(12, this.clear);
      paramVarArgs.aY(13, this.smileIconClick);
      paramVarArgs.aY(14, this.voiceIconClick);
      paramVarArgs.aY(15, this.fullScreenVoiceLongClick);
      paramVarArgs.bm(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.aY(17, this.showInit);
      paramVarArgs.bm(18, this.initChoose);
      paramVarArgs.aY(19, this.chooseArea);
      paramVarArgs.aY(20, this.chooseCantonese);
      paramVarArgs.aY(21, this.setlanguage);
      paramVarArgs.aY(22, this.setSwitchCantonese);
      paramVarArgs.aY(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.cancel);
      int i = g.a.a.b.b.a.bM(2, this.send);
      int j = g.a.a.b.b.a.bM(3, this.click);
      int k = g.a.a.b.b.a.bM(4, this.longClick);
      int m = g.a.a.b.b.a.p(5, this.longClickTime);
      int n = g.a.a.b.b.a.bM(6, this.textClick);
      int i1 = g.a.a.b.b.a.bM(7, this.textChangeCount);
      int i2 = g.a.a.b.b.a.p(8, this.textChangeTime);
      int i3 = g.a.a.b.b.a.bM(9, this.textChangeReturn);
      int i4 = g.a.a.b.b.a.p(10, this.voiceInputTime);
      int i5 = g.a.a.b.b.a.bM(11, this.fail);
      int i6 = g.a.a.b.b.a.bM(12, this.clear);
      int i7 = g.a.a.b.b.a.bM(13, this.smileIconClick);
      int i8 = g.a.a.b.b.a.bM(14, this.voiceIconClick);
      int i9 = g.a.a.b.b.a.bM(15, this.fullScreenVoiceLongClick);
      int i10 = g.a.a.b.b.a.p(16, this.fullScreenVoiceLongClickTime);
      int i11 = g.a.a.b.b.a.bM(17, this.showInit);
      int i12 = g.a.a.b.b.a.p(18, this.initChoose);
      int i13 = g.a.a.b.b.a.bM(19, this.chooseArea);
      int i14 = g.a.a.b.b.a.bM(20, this.chooseCantonese);
      int i15 = g.a.a.b.b.a.bM(21, this.setlanguage);
      int i16 = g.a.a.b.b.a.bM(22, this.setSwitchCantonese);
      int i17 = g.a.a.b.b.a.bM(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151541);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.abFh.AN();
        AppMethodBeat.o(151541);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.abFh.AN();
        AppMethodBeat.o(151541);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.abFh.AN();
        AppMethodBeat.o(151541);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.abFh.AN();
        AppMethodBeat.o(151541);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.abFh.AN();
        AppMethodBeat.o(151541);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.abFh.AK();
        AppMethodBeat.o(151541);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.abFh.AK();
      AppMethodBeat.o(151541);
      return 0;
    }
    AppMethodBeat.o(151541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */