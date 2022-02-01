package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uh
  extends cld
{
  public LinkedList<ui> CVY;
  public String dgo;
  public String ivl;
  public int iwC;
  
  public uh()
  {
    AppMethodBeat.i(190183);
    this.CVY = new LinkedList();
    AppMethodBeat.o(190183);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CVY);
      if (this.dgo != null) {
        paramVarArgs.d(3, this.dgo);
      }
      paramVarArgs.aR(4, this.iwC);
      if (this.ivl != null) {
        paramVarArgs.d(5, this.ivl);
      }
      AppMethodBeat.o(190184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.CVY);
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dgo);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.iwC);
      paramInt = i;
      if (this.ivl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ivl);
      }
      AppMethodBeat.o(190184);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CVY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(190184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uh localuh = (uh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190184);
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
            localuh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190184);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ui();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ui)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuh.CVY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190184);
          return 0;
        case 3: 
          localuh.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(190184);
          return 0;
        case 4: 
          localuh.iwC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(190184);
          return 0;
        }
        localuh.ivl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(190184);
        return 0;
      }
      AppMethodBeat.o(190184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uh
 * JD-Core Version:    0.7.0.1
 */