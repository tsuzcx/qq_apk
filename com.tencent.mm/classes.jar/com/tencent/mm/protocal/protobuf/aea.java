package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.i;
import java.util.LinkedList;

public final class aea
  extends cld
{
  public LinkedList<i> Dem;
  public int Den;
  public e.a.a.a Deo;
  public int ntx;
  public String nty;
  
  public aea()
  {
    AppMethodBeat.i(91444);
    this.Dem = new LinkedList();
    AppMethodBeat.o(91444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.e(4, 8, this.Dem);
      paramVarArgs.aR(5, this.Den);
      if (this.Deo != null)
      {
        paramVarArgs.kX(6, this.Deo.computeSize());
        this.Deo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Dem) + f.a.a.b.b.a.bA(5, this.Den);
      paramInt = i;
      if (this.Deo != null) {
        paramInt = i + f.a.a.a.kW(6, this.Deo.computeSize());
      }
      AppMethodBeat.o(91445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dem.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aea localaea = (aea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaea.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 2: 
          localaea.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91445);
          return 0;
        case 3: 
          localaea.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaea.Dem.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 5: 
          localaea.Den = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91445);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e.a.a.a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e.a.a.a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaea.Deo = ((e.a.a.a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      AppMethodBeat.o(91445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aea
 * JD-Core Version:    0.7.0.1
 */