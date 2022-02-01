package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chk
  extends cld
{
  public com.tencent.mm.bx.b DSZ;
  public int DTa;
  public int DTb;
  public String DTg;
  public String DTh;
  public String DTi;
  public int DTj;
  public String DTl;
  public String nvv;
  public int sYr;
  public int sYs;
  public String sYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DTa);
      if (this.sYt != null) {
        paramVarArgs.d(3, this.sYt);
      }
      if (this.DTh != null) {
        paramVarArgs.d(4, this.DTh);
      }
      if (this.DTi != null) {
        paramVarArgs.d(5, this.DTi);
      }
      if (this.DSZ != null) {
        paramVarArgs.c(6, this.DSZ);
      }
      paramVarArgs.aR(7, this.DTb);
      paramVarArgs.aR(8, this.sYr);
      paramVarArgs.aR(9, this.DTj);
      paramVarArgs.aR(10, this.sYs);
      if (this.nvv != null) {
        paramVarArgs.d(11, this.nvv);
      }
      if (this.DTl != null) {
        paramVarArgs.d(12, this.DTl);
      }
      if (this.DTg != null) {
        paramVarArgs.d(13, this.DTg);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DTa);
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sYt);
      }
      i = paramInt;
      if (this.DTh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DTh);
      }
      paramInt = i;
      if (this.DTi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DTi);
      }
      i = paramInt;
      if (this.DSZ != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.DSZ);
      }
      i = i + f.a.a.b.b.a.bA(7, this.DTb) + f.a.a.b.b.a.bA(8, this.sYr) + f.a.a.b.b.a.bA(9, this.DTj) + f.a.a.b.b.a.bA(10, this.sYs);
      paramInt = i;
      if (this.nvv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.nvv);
      }
      i = paramInt;
      if (this.DTl != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DTl);
      }
      paramInt = i;
      if (this.DTg != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DTg);
      }
      AppMethodBeat.o(91662);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chk localchk = (chk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localchk.DTa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localchk.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localchk.DTh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localchk.DTi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localchk.DSZ = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localchk.DTb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localchk.sYr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localchk.DTj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localchk.sYs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localchk.nvv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localchk.DTl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localchk.DTg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chk
 * JD-Core Version:    0.7.0.1
 */