package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdh
  extends ckq
{
  public int CYU;
  public String DYc;
  public String DZA;
  public int DZB;
  public String DZC;
  public int zFN;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZA != null) {
        paramVarArgs.d(2, this.DZA);
      }
      paramVarArgs.aR(3, this.DZB);
      paramVarArgs.aR(4, this.CYU);
      if (this.DZC != null) {
        paramVarArgs.d(5, this.DZC);
      }
      if (this.DYc != null) {
        paramVarArgs.d(7, this.DYc);
      }
      paramVarArgs.aR(8, this.zFN);
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DZA);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DZB) + f.a.a.b.b.a.bA(4, this.CYU);
      paramInt = i;
      if (this.DZC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DZC);
      }
      i = paramInt;
      if (this.DYc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DYc);
      }
      i += f.a.a.b.b.a.bA(8, this.zFN);
      paramInt = i;
      if (this.zFY != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdh localcdh = (cdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localcdh.DZA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localcdh.DZB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localcdh.CYU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localcdh.DZC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localcdh.DYc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localcdh.zFN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91636);
          return 0;
        }
        localcdh.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */