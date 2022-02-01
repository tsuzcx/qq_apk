package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eqf
  extends esc
{
  public int aasg;
  public LinkedList<Integer> aash;
  public LinkedList<aov> aasi;
  public int abud;
  
  public eqf()
  {
    AppMethodBeat.i(258948);
    this.aasi = new LinkedList();
    this.aash = new LinkedList();
    AppMethodBeat.o(258948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258952);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258952);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aasg);
      paramVarArgs.bS(3, this.abud);
      paramVarArgs.e(4, 8, this.aasi);
      paramVarArgs.e(5, 2, this.aash);
      AppMethodBeat.o(258952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label605;
      }
    }
    label605:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aasg);
      int j = i.a.a.b.b.a.cJ(3, this.abud);
      int k = i.a.a.a.c(4, 8, this.aasi);
      int m = i.a.a.a.c(5, 2, this.aash);
      AppMethodBeat.o(258952);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aasi.clear();
        this.aash.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258952);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eqf localeqf = (eqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258952);
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
            localeqf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258952);
          return 0;
        case 2: 
          localeqf.aasg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258952);
          return 0;
        case 3: 
          localeqf.abud = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258952);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aov)localObject2).parseFrom((byte[])localObject1);
            }
            localeqf.aasi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258952);
          return 0;
        }
        localeqf.aash.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
        AppMethodBeat.o(258952);
        return 0;
      }
      AppMethodBeat.o(258952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqf
 * JD-Core Version:    0.7.0.1
 */