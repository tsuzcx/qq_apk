package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cjp
  extends esc
{
  public LinkedList<fp> YIB;
  public int aasf;
  public int aasg;
  public LinkedList<Integer> aash;
  public LinkedList<aoz> aasi;
  public int aask;
  
  public cjp()
  {
    AppMethodBeat.i(122505);
    this.aash = new LinkedList();
    this.aasi = new LinkedList();
    this.YIB = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aasf);
      paramVarArgs.bS(3, this.aasg);
      paramVarArgs.e(4, 2, this.aash);
      paramVarArgs.e(5, 8, this.aasi);
      paramVarArgs.bS(6, this.aask);
      paramVarArgs.e(7, 8, this.YIB);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aasf);
      int j = i.a.a.b.b.a.cJ(3, this.aasg);
      int k = i.a.a.a.c(4, 2, this.aash);
      int m = i.a.a.a.c(5, 8, this.aasi);
      int n = i.a.a.b.b.a.cJ(6, this.aask);
      int i1 = i.a.a.a.c(7, 8, this.YIB);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aash.clear();
        this.aasi.clear();
        this.YIB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cjp localcjp = (cjp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
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
            localcjp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localcjp.aasf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localcjp.aasg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localcjp.aash.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aoz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aoz)localObject2).parseFrom((byte[])localObject1);
            }
            localcjp.aasi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localcjp.aask = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fp)localObject2).parseFrom((byte[])localObject1);
          }
          localcjp.YIB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjp
 * JD-Core Version:    0.7.0.1
 */