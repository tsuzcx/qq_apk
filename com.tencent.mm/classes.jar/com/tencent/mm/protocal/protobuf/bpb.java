package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bpb
  extends com.tencent.mm.bx.a
{
  public long DLh;
  public bhk DMA;
  public long DMB;
  public LinkedList<b> DMz;
  public long dcn;
  public long id;
  
  public bpb()
  {
    AppMethodBeat.i(110903);
    this.DMz = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.id);
      paramVarArgs.e(2, 6, this.DMz);
      if (this.DMA != null)
      {
        paramVarArgs.kX(3, this.DMA.computeSize());
        this.DMA.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(4, this.dcn);
      paramVarArgs.aG(5, this.DLh);
      paramVarArgs.aG(6, this.DMB);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.id) + 0 + f.a.a.a.c(2, 6, this.DMz);
      paramInt = i;
      if (this.DMA != null) {
        paramInt = i + f.a.a.a.kW(3, this.DMA.computeSize());
      }
      i = f.a.a.b.b.a.q(4, this.dcn);
      int j = f.a.a.b.b.a.q(5, this.DLh);
      int k = f.a.a.b.b.a.q(6, this.DMB);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DMz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpb localbpb = (bpb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localbpb.id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localbpb.DMz.add(((f.a.a.a.a)localObject1).KhF.fMu());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpb.DMA = ((bhk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localbpb.dcn = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localbpb.DLh = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110904);
        return 0;
      }
      localbpb.DMB = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpb
 * JD-Core Version:    0.7.0.1
 */