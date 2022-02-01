package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cgi
  extends esc
{
  public boolean aaps;
  public int aapt;
  public int aapu;
  public wg aapv;
  public boolean aapw;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.di(4, this.aaps);
      paramVarArgs.bS(5, this.aapt);
      paramVarArgs.bS(6, this.aapu);
      if (this.aapv != null)
      {
        paramVarArgs.qD(7, this.aapv.computeSize());
        this.aapv.writeFields(paramVarArgs);
      }
      paramVarArgs.di(8, this.aapw);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.cJ(5, this.aapt) + i.a.a.b.b.a.cJ(6, this.aapu);
      paramInt = i;
      if (this.aapv != null) {
        paramInt = i + i.a.a.a.qC(7, this.aapv.computeSize());
      }
      i = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(114007);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cgi localcgi = (cgi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcgi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localcgi.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localcgi.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localcgi.aaps = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localcgi.aapt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localcgi.aapu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localcgi.aapv = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localcgi.aapw = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgi
 * JD-Core Version:    0.7.0.1
 */