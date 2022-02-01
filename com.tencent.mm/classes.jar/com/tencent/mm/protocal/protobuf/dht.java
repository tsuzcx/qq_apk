package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dht
  extends com.tencent.mm.bx.a
{
  public int Hwc;
  public int Hwd;
  public int Hwe;
  public dws Hwf;
  public int Hwg;
  public int Hwh;
  public int Hwi;
  public int Hwj;
  public LinkedList<Integer> Hwk;
  public int Hwl;
  public LinkedList<Integer> Hwm;
  public int Hwn;
  public LinkedList<Integer> Hwo;
  public String Hwp;
  
  public dht()
  {
    AppMethodBeat.i(115851);
    this.Hwk = new LinkedList();
    this.Hwm = new LinkedList();
    this.Hwo = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hwf == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Hwc);
      paramVarArgs.aS(2, this.Hwd);
      paramVarArgs.aS(3, this.Hwe);
      if (this.Hwf != null)
      {
        paramVarArgs.lC(4, this.Hwf.computeSize());
        this.Hwf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hwg);
      paramVarArgs.aS(6, this.Hwh);
      paramVarArgs.aS(7, this.Hwi);
      paramVarArgs.aS(8, this.Hwj);
      paramVarArgs.f(9, 2, this.Hwk);
      paramVarArgs.aS(10, this.Hwl);
      paramVarArgs.f(11, 2, this.Hwm);
      paramVarArgs.aS(12, this.Hwn);
      paramVarArgs.f(13, 2, this.Hwo);
      if (this.Hwp != null) {
        paramVarArgs.d(14, this.Hwp);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hwc) + 0 + f.a.a.b.b.a.bz(2, this.Hwd) + f.a.a.b.b.a.bz(3, this.Hwe);
      paramInt = i;
      if (this.Hwf != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hwf.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hwg) + f.a.a.b.b.a.bz(6, this.Hwh) + f.a.a.b.b.a.bz(7, this.Hwi) + f.a.a.b.b.a.bz(8, this.Hwj) + f.a.a.a.d(9, 2, this.Hwk) + f.a.a.b.b.a.bz(10, this.Hwl) + f.a.a.a.d(11, 2, this.Hwm) + f.a.a.b.b.a.bz(12, this.Hwn) + f.a.a.a.d(13, 2, this.Hwo);
      paramInt = i;
      if (this.Hwp != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Hwp);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hwk.clear();
      this.Hwm.clear();
      this.Hwo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Hwf == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dht localdht = (dht)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localdht.Hwc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localdht.Hwd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localdht.Hwe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dws();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdht.Hwf = ((dws)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localdht.Hwg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localdht.Hwh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localdht.Hwi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localdht.Hwj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localdht.Hwk = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localdht.Hwl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localdht.Hwm = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localdht.Hwn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localdht.Hwo = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
        AppMethodBeat.o(115852);
        return 0;
      }
      localdht.Hwp = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dht
 * JD-Core Version:    0.7.0.1
 */