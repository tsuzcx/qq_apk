package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class boa
  extends com.tencent.mm.bx.a
{
  public int DLi;
  public float DLm;
  public float DLn;
  public String DLo;
  public LinkedList<String> DLp;
  public String DLq;
  public LinkedList<String> DLr;
  public LinkedList<bob> DLs;
  public LinkedList<bny> DLt;
  public int DLu;
  public int dlI;
  public int duration;
  public String gKQ;
  public String iay;
  
  public boa()
  {
    AppMethodBeat.i(169924);
    this.DLp = new LinkedList();
    this.DLr = new LinkedList();
    this.DLs = new LinkedList();
    this.DLt = new LinkedList();
    this.DLu = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DLo == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DLi);
      paramVarArgs.x(2, this.DLm);
      paramVarArgs.x(3, this.DLn);
      if (this.DLo != null) {
        paramVarArgs.d(4, this.DLo);
      }
      paramVarArgs.e(5, 1, this.DLp);
      if (this.DLq != null) {
        paramVarArgs.d(6, this.DLq);
      }
      paramVarArgs.e(7, 1, this.DLr);
      paramVarArgs.e(8, 8, this.DLs);
      if (this.iay != null) {
        paramVarArgs.d(9, this.iay);
      }
      if (this.gKQ != null) {
        paramVarArgs.d(10, this.gKQ);
      }
      paramVarArgs.e(11, 8, this.DLt);
      paramVarArgs.aR(12, this.dlI);
      paramVarArgs.aR(13, this.duration);
      paramVarArgs.aR(14, this.DLu);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DLi) + 0 + (f.a.a.b.b.a.fY(2) + 4) + (f.a.a.b.b.a.fY(3) + 4);
      paramInt = i;
      if (this.DLo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLo);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.DLp);
      paramInt = i;
      if (this.DLq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DLq);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.DLr) + f.a.a.a.c(8, 8, this.DLs);
      paramInt = i;
      if (this.iay != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iay);
      }
      i = paramInt;
      if (this.gKQ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.gKQ);
      }
      paramInt = f.a.a.a.c(11, 8, this.DLt);
      int j = f.a.a.b.b.a.bA(12, this.dlI);
      int k = f.a.a.b.b.a.bA(13, this.duration);
      int m = f.a.a.b.b.a.bA(14, this.DLu);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DLp.clear();
      this.DLr.clear();
      this.DLs.clear();
      this.DLt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DLo == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      boa localboa = (boa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localboa.DLi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localboa.DLm = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localboa.DLn = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localboa.DLo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localboa.DLp.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localboa.DLq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localboa.DLr.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localboa.DLs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localboa.iay = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localboa.gKQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bny();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localboa.DLt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localboa.dlI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localboa.duration = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169925);
        return 0;
      }
      localboa.DLu = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boa
 * JD-Core Version:    0.7.0.1
 */