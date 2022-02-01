package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etb
  extends dpc
{
  public LinkedList<esv> KMD;
  public long Lta;
  public com.tencent.mm.bw.b MKv;
  public int Ndy;
  public long NeG;
  public int NqA;
  public LinkedList<esv> NqB;
  public int Nqy;
  public int Nqz;
  public int ypR;
  public int ypX;
  public int ypY;
  public int yqc;
  
  public etb()
  {
    AppMethodBeat.i(125499);
    this.KMD = new LinkedList();
    this.NqB = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.NeG);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.e(4, 8, this.KMD);
      paramVarArgs.aM(5, this.Ndy);
      paramVarArgs.aM(6, this.ypX);
      paramVarArgs.aM(7, this.ypY);
      paramVarArgs.aM(8, this.ypR);
      paramVarArgs.aM(9, this.yqc);
      paramVarArgs.aM(10, this.Nqy);
      paramVarArgs.aM(11, this.Nqz);
      if (this.MKv != null) {
        paramVarArgs.c(12, this.MKv);
      }
      paramVarArgs.aM(13, this.NqA);
      paramVarArgs.e(14, 8, this.NqB);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.NeG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.a.c(4, 8, this.KMD) + g.a.a.b.b.a.bu(5, this.Ndy) + g.a.a.b.b.a.bu(6, this.ypX) + g.a.a.b.b.a.bu(7, this.ypY) + g.a.a.b.b.a.bu(8, this.ypR) + g.a.a.b.b.a.bu(9, this.yqc) + g.a.a.b.b.a.bu(10, this.Nqy) + g.a.a.b.b.a.bu(11, this.Nqz);
      paramInt = i;
      if (this.MKv != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.MKv);
      }
      i = g.a.a.b.b.a.bu(13, this.NqA);
      int j = g.a.a.a.c(14, 8, this.NqB);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KMD.clear();
        this.NqB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etb localetb = (etb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localetb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localetb.NeG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localetb.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localetb.KMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localetb.Ndy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localetb.ypX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localetb.ypY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localetb.ypR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localetb.yqc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localetb.Nqy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localetb.Nqz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localetb.MKv = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localetb.NqA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localetb.NqB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etb
 * JD-Core Version:    0.7.0.1
 */