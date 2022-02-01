package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czr
  extends com.tencent.mm.bx.a
{
  public fns aaEZ;
  public fns aaFa;
  public String aaFb;
  public String aaFc;
  public boolean aaFd = false;
  public boolean aaFe;
  public czv aaFf;
  public fxz aaFg;
  public ckz aaFh;
  public String aajk;
  public int aajl;
  public String aajm;
  public boolean aajn = false;
  public boolean aajo = false;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msgType);
      if (this.aaEZ != null)
      {
        paramVarArgs.qD(2, this.aaEZ.computeSize());
        this.aaEZ.writeFields(paramVarArgs);
      }
      if (this.aaFa != null)
      {
        paramVarArgs.qD(3, this.aaFa.computeSize());
        this.aaFa.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.aajn);
      if (this.aajk != null) {
        paramVarArgs.g(5, this.aajk);
      }
      paramVarArgs.bS(6, this.flags);
      if (this.aajm != null) {
        paramVarArgs.g(7, this.aajm);
      }
      if (this.aaFb != null) {
        paramVarArgs.g(8, this.aaFb);
      }
      if (this.aaFc != null) {
        paramVarArgs.g(9, this.aaFc);
      }
      paramVarArgs.di(10, this.aaFd);
      paramVarArgs.di(11, this.aaFe);
      paramVarArgs.di(12, this.aajo);
      if (this.aaFf != null)
      {
        paramVarArgs.qD(13, this.aaFf.computeSize());
        this.aaFf.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(14, this.timestamp);
      if (this.aaFg != null)
      {
        paramVarArgs.qD(15, this.aaFg.computeSize());
        this.aaFg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.aajl);
      if (this.aaFh != null)
      {
        paramVarArgs.qD(17, this.aaFh.computeSize());
        this.aaFh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.msgType) + 0;
      paramInt = i;
      if (this.aaEZ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaEZ.computeSize());
      }
      i = paramInt;
      if (this.aaFa != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaFa.computeSize());
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.aajk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aajk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.flags);
      paramInt = i;
      if (this.aajm != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aajm);
      }
      i = paramInt;
      if (this.aaFb != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaFb);
      }
      paramInt = i;
      if (this.aaFc != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaFc);
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 1) + (i.a.a.b.b.a.ko(11) + 1) + (i.a.a.b.b.a.ko(12) + 1);
      paramInt = i;
      if (this.aaFf != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaFf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(14, this.timestamp);
      paramInt = i;
      if (this.aaFg != null) {
        paramInt = i + i.a.a.a.qC(15, this.aaFg.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.aajl);
      paramInt = i;
      if (this.aaFh != null) {
        paramInt = i + i.a.a.a.qC(17, this.aaFh.computeSize());
      }
      AppMethodBeat.o(122507);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      czr localczr = (czr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localczr.msgType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122507);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fns();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fns)localObject2).parseFrom((byte[])localObject1);
          }
          localczr.aaEZ = ((fns)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fns();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fns)localObject2).parseFrom((byte[])localObject1);
          }
          localczr.aaFa = ((fns)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localczr.aajn = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localczr.aajk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localczr.flags = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localczr.aajm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localczr.aaFb = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localczr.aaFc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localczr.aaFd = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localczr.aaFe = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localczr.aajo = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new czv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((czv)localObject2).parseFrom((byte[])localObject1);
          }
          localczr.aaFf = ((czv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 14: 
        localczr.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(122507);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fxz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fxz)localObject2).parseFrom((byte[])localObject1);
          }
          localczr.aaFg = ((fxz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 16: 
        localczr.aajl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122507);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ckz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ckz)localObject2).parseFrom((byte[])localObject1);
        }
        localczr.aaFh = ((ckz)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czr
 * JD-Core Version:    0.7.0.1
 */