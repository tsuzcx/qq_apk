package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzb
  extends esc
{
  public LinkedList<etl> YFl;
  public int aaqr;
  public String abWC;
  public int oOu;
  
  public fzb()
  {
    AppMethodBeat.i(148665);
    this.YFl = new LinkedList();
    AppMethodBeat.o(148665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.oOu);
      paramVarArgs.bS(3, this.aaqr);
      paramVarArgs.e(4, 8, this.YFl);
      if (this.abWC != null) {
        paramVarArgs.g(5, this.abWC);
      }
      AppMethodBeat.o(148666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.oOu) + i.a.a.b.b.a.cJ(3, this.aaqr) + i.a.a.a.c(4, 8, this.YFl);
      paramInt = i;
      if (this.abWC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abWC);
      }
      AppMethodBeat.o(148666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzb localfzb = (fzb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148666);
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
            localfzb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        case 2: 
          localfzb.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148666);
          return 0;
        case 3: 
          localfzb.aaqr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148666);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfzb.YFl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        }
        localfzb.abWC = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(148666);
        return 0;
      }
      AppMethodBeat.o(148666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzb
 * JD-Core Version:    0.7.0.1
 */