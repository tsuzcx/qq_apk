package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avb
  extends dyy
{
  public int RDl;
  public LinkedList<bcc> SCI;
  public b SDI;
  public long SHj;
  public float SHs;
  public long SHt;
  public long SHu;
  public int xFI;
  
  public avb()
  {
    AppMethodBeat.i(231228);
    this.SCI = new LinkedList();
    AppMethodBeat.o(231228);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231231);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RDl);
      paramVarArgs.i(3, this.SHs);
      if (this.SDI != null) {
        paramVarArgs.c(4, this.SDI);
      }
      paramVarArgs.aY(5, this.xFI);
      paramVarArgs.e(6, 8, this.SCI);
      paramVarArgs.bm(7, this.SHt);
      paramVarArgs.bm(8, this.SHj);
      paramVarArgs.bm(9, this.SHu);
      AppMethodBeat.o(231231);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label745;
      }
    }
    label745:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RDl) + (g.a.a.b.b.a.gL(3) + 4);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.SDI);
      }
      i = g.a.a.b.b.a.bM(5, this.xFI);
      int j = g.a.a.a.c(6, 8, this.SCI);
      int k = g.a.a.b.b.a.p(7, this.SHt);
      int m = g.a.a.b.b.a.p(8, this.SHj);
      int n = g.a.a.b.b.a.p(9, this.SHu);
      AppMethodBeat.o(231231);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SCI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231231);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avb localavb = (avb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231231);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localavb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231231);
          return 0;
        case 2: 
          localavb.RDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231231);
          return 0;
        case 3: 
          localavb.SHs = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(231231);
          return 0;
        case 4: 
          localavb.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231231);
          return 0;
        case 5: 
          localavb.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231231);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcc)localObject2).parseFrom((byte[])localObject1);
            }
            localavb.SCI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231231);
          return 0;
        case 7: 
          localavb.SHt = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231231);
          return 0;
        case 8: 
          localavb.SHj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231231);
          return 0;
        }
        localavb.SHu = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(231231);
        return 0;
      }
      AppMethodBeat.o(231231);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */