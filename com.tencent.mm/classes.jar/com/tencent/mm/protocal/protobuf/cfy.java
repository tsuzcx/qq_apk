package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfy
  extends esc
{
  public int YYp;
  public LinkedList<dps> aapk;
  public int crz;
  public int vgN;
  
  public cfy()
  {
    AppMethodBeat.i(32224);
    this.aapk = new LinkedList();
    AppMethodBeat.o(32224);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32225);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32225);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(5, 8, this.aapk);
      paramVarArgs.bS(6, this.crz);
      paramVarArgs.bS(7, this.YYp);
      AppMethodBeat.o(32225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label617;
      }
    }
    label617:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(5, 8, this.aapk);
      int k = i.a.a.b.b.a.cJ(6, this.crz);
      int m = i.a.a.b.b.a.cJ(7, this.YYp);
      AppMethodBeat.o(32225);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aapk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32225);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfy localcfy = (cfy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(32225);
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
            localcfy.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 2: 
          localcfy.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32225);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dps();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dps)localObject2).parseFrom((byte[])localObject1);
            }
            localcfy.aapk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 6: 
          localcfy.crz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32225);
          return 0;
        }
        localcfy.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32225);
        return 0;
      }
      AppMethodBeat.o(32225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfy
 * JD-Core Version:    0.7.0.1
 */