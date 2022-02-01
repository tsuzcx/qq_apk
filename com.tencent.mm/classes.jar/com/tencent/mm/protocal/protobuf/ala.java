package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ala
  extends cld
{
  public int continueFlag;
  public String dnB;
  public int offset;
  public b qHz;
  public LinkedList<FinderObject> qbe;
  public LinkedList<aky> tvP;
  
  public ala()
  {
    AppMethodBeat.i(169049);
    this.tvP = new LinkedList();
    this.qbe = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.tvP);
      paramVarArgs.aR(3, this.offset);
      paramVarArgs.aR(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.qbe);
      if (this.qHz != null) {
        paramVarArgs.c(6, this.qHz);
      }
      if (this.dnB != null) {
        paramVarArgs.d(7, this.dnB);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.tvP) + f.a.a.b.b.a.bA(3, this.offset) + f.a.a.b.b.a.bA(4, this.continueFlag) + f.a.a.a.c(5, 8, this.qbe);
      paramInt = i;
      if (this.qHz != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.qHz);
      }
      i = paramInt;
      if (this.dnB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dnB);
      }
      AppMethodBeat.o(169050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tvP.clear();
        this.qbe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ala localala = (ala)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
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
            localala.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localala.tvP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localala.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localala.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localala.qbe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localala.qHz = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(169050);
          return 0;
        }
        localala.dnB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ala
 * JD-Core Version:    0.7.0.1
 */