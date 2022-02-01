package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsp
  extends com.tencent.mm.bx.a
{
  public String Mcq;
  public dsn aaYh;
  public int aaYi;
  public boolean aaYj;
  public String hNw;
  public int ret;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259608);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ret);
      if (this.hNw != null) {
        paramVarArgs.g(2, this.hNw);
      }
      if (this.aaYh != null)
      {
        paramVarArgs.qD(3, this.aaYh.computeSize());
        this.aaYh.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      paramVarArgs.bS(5, this.aaYi);
      paramVarArgs.di(6, this.aaYj);
      if (this.Mcq != null) {
        paramVarArgs.g(7, this.Mcq);
      }
      AppMethodBeat.o(259608);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ret) + 0;
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hNw);
      }
      i = paramInt;
      if (this.aaYh != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaYh.computeSize());
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaYi) + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.Mcq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Mcq);
      }
      AppMethodBeat.o(259608);
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
      AppMethodBeat.o(259608);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dsp localdsp = (dsp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259608);
        return -1;
      case 1: 
        localdsp.ret = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259608);
        return 0;
      case 2: 
        localdsp.hNw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259608);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dsn localdsn = new dsn();
          if ((localObject != null) && (localObject.length > 0)) {
            localdsn.parseFrom((byte[])localObject);
          }
          localdsp.aaYh = localdsn;
          paramInt += 1;
        }
        AppMethodBeat.o(259608);
        return 0;
      case 4: 
        localdsp.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259608);
        return 0;
      case 5: 
        localdsp.aaYi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259608);
        return 0;
      case 6: 
        localdsp.aaYj = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259608);
        return 0;
      }
      localdsp.Mcq = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259608);
      return 0;
    }
    AppMethodBeat.o(259608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsp
 * JD-Core Version:    0.7.0.1
 */