package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efw
  extends esc
{
  public String YBl;
  public String YBm;
  public String able;
  public String ablf;
  public String ablg;
  public String ablh;
  public String background_color;
  public String content;
  public int status;
  public boolean wuU;
  public String wul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YBl != null) {
        paramVarArgs.g(2, this.YBl);
      }
      if (this.YBm != null) {
        paramVarArgs.g(3, this.YBm);
      }
      paramVarArgs.bS(4, this.status);
      if (this.content != null) {
        paramVarArgs.g(5, this.content);
      }
      if (this.wul != null) {
        paramVarArgs.g(6, this.wul);
      }
      if (this.background_color != null) {
        paramVarArgs.g(7, this.background_color);
      }
      paramVarArgs.di(8, this.wuU);
      if (this.able != null) {
        paramVarArgs.g(9, this.able);
      }
      if (this.ablf != null) {
        paramVarArgs.g(10, this.ablf);
      }
      if (this.ablg != null) {
        paramVarArgs.g(11, this.ablg);
      }
      if (this.ablh != null) {
        paramVarArgs.g(12, this.ablh);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label924;
      }
    }
    label924:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YBl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBl);
      }
      i = paramInt;
      if (this.YBm != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBm);
      }
      i += i.a.a.b.b.a.cJ(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.content);
      }
      i = paramInt;
      if (this.wul != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.wul);
      }
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.background_color);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.able != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.able);
      }
      i = paramInt;
      if (this.ablf != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ablf);
      }
      paramInt = i;
      if (this.ablg != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ablg);
      }
      i = paramInt;
      if (this.ablh != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ablh);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        efw localefw = (efw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localefw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localefw.YBl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localefw.YBm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localefw.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localefw.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localefw.wul = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localefw.background_color = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localefw.wuU = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localefw.able = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localefw.ablf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localefw.ablg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localefw.ablh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efw
 * JD-Core Version:    0.7.0.1
 */