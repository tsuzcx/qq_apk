package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmj
  extends esc
{
  public com.tencent.mm.bx.b YJa;
  public int ZWw;
  public LinkedList<dir> aaul;
  public LinkedList<String> aaum;
  public int aaun;
  public boolean aauo;
  public dil aaup;
  
  public cmj()
  {
    AppMethodBeat.i(257553);
    this.aaul = new LinkedList();
    this.aaum = new LinkedList();
    AppMethodBeat.o(257553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257561);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaul);
      if (this.YJa != null) {
        paramVarArgs.d(3, this.YJa);
      }
      paramVarArgs.bS(4, this.ZWw);
      paramVarArgs.e(5, 1, this.aaum);
      paramVarArgs.bS(6, this.aaun);
      paramVarArgs.di(7, this.aauo);
      if (this.aaup != null)
      {
        paramVarArgs.qD(8, this.aaup.computeSize());
        this.aaup.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaul);
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YJa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZWw) + i.a.a.a.c(5, 1, this.aaum) + i.a.a.b.b.a.cJ(6, this.aaun) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.aaup != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaup.computeSize());
      }
      AppMethodBeat.o(257561);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaul.clear();
        this.aaum.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cmj localcmj = (cmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257561);
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
            localcmj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257561);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dir();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dir)localObject2).parseFrom((byte[])localObject1);
            }
            localcmj.aaul.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257561);
          return 0;
        case 3: 
          localcmj.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257561);
          return 0;
        case 4: 
          localcmj.ZWw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257561);
          return 0;
        case 5: 
          localcmj.aaum.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257561);
          return 0;
        case 6: 
          localcmj.aaun = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257561);
          return 0;
        case 7: 
          localcmj.aauo = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257561);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dil();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dil)localObject2).parseFrom((byte[])localObject1);
          }
          localcmj.aaup = ((dil)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257561);
        return 0;
      }
      AppMethodBeat.o(257561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */