package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciq
  extends com.tencent.mm.bx.a
{
  public int YWM;
  public int aaqo;
  public erm aard;
  public boolean aarj;
  public boolean aark;
  public String aarl;
  public int hGE;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hGE);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      paramVarArgs.bS(4, this.aaqo);
      paramVarArgs.bS(5, this.YWM);
      paramVarArgs.di(6, this.aarj);
      paramVarArgs.di(7, this.aark);
      if (this.aard != null)
      {
        paramVarArgs.qD(20, this.aard.computeSize());
        this.aard.writeFields(paramVarArgs);
      }
      if (this.aarl != null) {
        paramVarArgs.g(21, this.aarl);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.hGE) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaqo) + i.a.a.b.b.a.cJ(5, this.YWM) + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.aard != null) {
        paramInt = i + i.a.a.a.qC(20, this.aard.computeSize());
      }
      i = paramInt;
      if (this.aarl != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.aarl);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ciq localciq = (ciq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localciq.hGE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localciq.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localciq.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localciq.aaqo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localciq.YWM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localciq.aarj = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localciq.aark = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          erm localerm = new erm();
          if ((localObject != null) && (localObject.length > 0)) {
            localerm.parseFrom((byte[])localObject);
          }
          localciq.aard = localerm;
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localciq.aarl = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciq
 * JD-Core Version:    0.7.0.1
 */