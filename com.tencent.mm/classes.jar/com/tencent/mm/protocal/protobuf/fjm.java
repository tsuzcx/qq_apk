package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fjm
  extends esc
{
  public int aaiS;
  public String abDu;
  public int abFi;
  public long abJj;
  public int abKf;
  public LinkedList<fiz> abKg;
  public int abKh;
  public int abKi;
  
  public fjm()
  {
    AppMethodBeat.i(118477);
    this.abKg = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bS(3, this.abKf);
      paramVarArgs.e(4, 8, this.abKg);
      paramVarArgs.bS(5, this.abKh);
      paramVarArgs.bS(6, this.abKi);
      paramVarArgs.bS(7, this.abFi);
      paramVarArgs.bv(8, this.abJj);
      paramVarArgs.bS(9, this.aaiS);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abKf);
      int j = i.a.a.a.c(4, 8, this.abKg);
      int k = i.a.a.b.b.a.cJ(5, this.abKh);
      int m = i.a.a.b.b.a.cJ(6, this.abKi);
      int n = i.a.a.b.b.a.cJ(7, this.abFi);
      int i1 = i.a.a.b.b.a.q(8, this.abJj);
      int i2 = i.a.a.b.b.a.cJ(9, this.aaiS);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abKg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fjm localfjm = (fjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
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
            localfjm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localfjm.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localfjm.abKf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fiz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fiz)localObject2).parseFrom((byte[])localObject1);
            }
            localfjm.abKg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localfjm.abKh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localfjm.abKi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localfjm.abFi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localfjm.abJj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(118478);
          return 0;
        }
        localfjm.aaiS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjm
 * JD-Core Version:    0.7.0.1
 */