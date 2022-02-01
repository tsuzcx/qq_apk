package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlr
  extends ckq
{
  public int CYi;
  public long DYU;
  public int DYV;
  public String EBF;
  public com.tencent.mm.bx.b EBG;
  public com.tencent.mm.bx.b EBH;
  public String EBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.EBH == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DYV);
      if (this.EBF != null) {
        paramVarArgs.d(3, this.EBF);
      }
      paramVarArgs.aR(4, this.CYi);
      if (this.EBG != null) {
        paramVarArgs.c(5, this.EBG);
      }
      if (this.EBH != null) {
        paramVarArgs.c(6, this.EBH);
      }
      paramVarArgs.aG(7, this.DYU);
      if (this.EBI != null) {
        paramVarArgs.d(8, this.EBI);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DYV);
      paramInt = i;
      if (this.EBF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EBF);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CYi);
      paramInt = i;
      if (this.EBG != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.EBG);
      }
      i = paramInt;
      if (this.EBH != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.EBH);
      }
      i += f.a.a.b.b.a.q(7, this.DYU);
      paramInt = i;
      if (this.EBI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EBI);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EBF == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.EBH == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlr localdlr = (dlr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
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
            localdlr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localdlr.DYV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localdlr.EBF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localdlr.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localdlr.EBG = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localdlr.EBH = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localdlr.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125498);
          return 0;
        }
        localdlr.EBI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlr
 * JD-Core Version:    0.7.0.1
 */