package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputBehavior
  extends com.tencent.mm.bw.a
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
      paramVarArgs.aM(1, this.cancel);
      paramVarArgs.aM(2, this.send);
      paramVarArgs.aM(3, this.click);
      paramVarArgs.aM(4, this.longClick);
      paramVarArgs.bb(5, this.longClickTime);
      paramVarArgs.aM(6, this.textClick);
      paramVarArgs.aM(7, this.textChangeCount);
      paramVarArgs.bb(8, this.textChangeTime);
      paramVarArgs.aM(9, this.textChangeReturn);
      paramVarArgs.bb(10, this.voiceInputTime);
      paramVarArgs.aM(11, this.fail);
      paramVarArgs.aM(12, this.clear);
      paramVarArgs.aM(13, this.smileIconClick);
      paramVarArgs.aM(14, this.voiceIconClick);
      paramVarArgs.aM(15, this.fullScreenVoiceLongClick);
      paramVarArgs.bb(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.aM(17, this.showInit);
      paramVarArgs.bb(18, this.initChoose);
      paramVarArgs.aM(19, this.chooseArea);
      paramVarArgs.aM(20, this.chooseCantonese);
      paramVarArgs.aM(21, this.setlanguage);
      paramVarArgs.aM(22, this.setSwitchCantonese);
      paramVarArgs.aM(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.cancel);
      int i = g.a.a.b.b.a.bu(2, this.send);
      int j = g.a.a.b.b.a.bu(3, this.click);
      int k = g.a.a.b.b.a.bu(4, this.longClick);
      int m = g.a.a.b.b.a.r(5, this.longClickTime);
      int n = g.a.a.b.b.a.bu(6, this.textClick);
      int i1 = g.a.a.b.b.a.bu(7, this.textChangeCount);
      int i2 = g.a.a.b.b.a.r(8, this.textChangeTime);
      int i3 = g.a.a.b.b.a.bu(9, this.textChangeReturn);
      int i4 = g.a.a.b.b.a.r(10, this.voiceInputTime);
      int i5 = g.a.a.b.b.a.bu(11, this.fail);
      int i6 = g.a.a.b.b.a.bu(12, this.clear);
      int i7 = g.a.a.b.b.a.bu(13, this.smileIconClick);
      int i8 = g.a.a.b.b.a.bu(14, this.voiceIconClick);
      int i9 = g.a.a.b.b.a.bu(15, this.fullScreenVoiceLongClick);
      int i10 = g.a.a.b.b.a.r(16, this.fullScreenVoiceLongClickTime);
      int i11 = g.a.a.b.b.a.bu(17, this.showInit);
      int i12 = g.a.a.b.b.a.r(18, this.initChoose);
      int i13 = g.a.a.b.b.a.bu(19, this.chooseArea);
      int i14 = g.a.a.b.b.a.bu(20, this.chooseCantonese);
      int i15 = g.a.a.b.b.a.bu(21, this.setlanguage);
      int i16 = g.a.a.b.b.a.bu(22, this.setSwitchCantonese);
      int i17 = g.a.a.b.b.a.bu(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localVoiceInputBehavior.cancel = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.UbS.zl();
        AppMethodBeat.o(151541);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.UbS.zl();
        AppMethodBeat.o(151541);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.UbS.zl();
        AppMethodBeat.o(151541);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.UbS.zl();
        AppMethodBeat.o(151541);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.UbS.zl();
        AppMethodBeat.o(151541);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.UbS.zi();
        AppMethodBeat.o(151541);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.UbS.zi();
      AppMethodBeat.o(151541);
      return 0;
    }
    AppMethodBeat.o(151541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */