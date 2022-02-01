package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsn
  extends com.tencent.mm.bx.a
{
  public long CJo;
  public String DLo;
  public String DLq;
  public LinkedList<String> DLr;
  public LinkedList<bob> DLs;
  public String DPH;
  public long Dpf;
  public long Dpg;
  
  public bsn()
  {
    AppMethodBeat.i(110907);
    this.DLr = new LinkedList();
    this.DLs = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Dpg);
      paramVarArgs.aG(2, this.Dpf);
      if (this.DLo != null) {
        paramVarArgs.d(3, this.DLo);
      }
      paramVarArgs.aG(4, this.CJo);
      if (this.DLq != null) {
        paramVarArgs.d(5, this.DLq);
      }
      paramVarArgs.e(6, 1, this.DLr);
      paramVarArgs.e(7, 8, this.DLs);
      if (this.DPH != null) {
        paramVarArgs.d(8, this.DPH);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Dpg) + 0 + f.a.a.b.b.a.q(2, this.Dpf);
      paramInt = i;
      if (this.DLo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DLo);
      }
      i = paramInt + f.a.a.b.b.a.q(4, this.CJo);
      paramInt = i;
      if (this.DLq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLq);
      }
      i = paramInt + f.a.a.a.c(6, 1, this.DLr) + f.a.a.a.c(7, 8, this.DLs);
      paramInt = i;
      if (this.DPH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DPH);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DLr.clear();
      this.DLs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bsn localbsn = (bsn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localbsn.Dpg = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localbsn.Dpf = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localbsn.DLo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localbsn.CJo = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localbsn.DLq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localbsn.DLr.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsn.DLs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localbsn.DPH = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsn
 * JD-Core Version:    0.7.0.1
 */