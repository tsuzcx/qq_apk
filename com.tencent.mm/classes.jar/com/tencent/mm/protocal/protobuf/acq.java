package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class acq
  extends com.tencent.mm.bx.a
  implements fcu
{
  public int Idd;
  public int Zla;
  public int Zlb;
  public int Zlc;
  public LinkedList<fjn> Zld;
  public LinkedList<fjn> Zle;
  public LinkedList<fjn> Zlf;
  public int Zlg;
  public int Zlh;
  public int Zli;
  public czq Zlj;
  
  public acq()
  {
    AppMethodBeat.i(143969);
    this.Zld = new LinkedList();
    this.Zle = new LinkedList();
    this.Zlf = new LinkedList();
    AppMethodBeat.o(143969);
  }
  
  public final int getRet()
  {
    return this.Idd;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143970);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      paramVarArgs.bS(2, this.Zla);
      paramVarArgs.bS(3, this.Zlb);
      paramVarArgs.bS(4, this.Zlc);
      paramVarArgs.e(5, 8, this.Zld);
      paramVarArgs.e(6, 8, this.Zle);
      paramVarArgs.e(7, 8, this.Zlf);
      paramVarArgs.bS(8, this.Zlg);
      paramVarArgs.bS(9, this.Zlh);
      paramVarArgs.bS(10, this.Zli);
      if (this.Zlj != null)
      {
        paramVarArgs.qD(11, this.Zlj.computeSize());
        this.Zlj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0 + i.a.a.b.b.a.cJ(2, this.Zla) + i.a.a.b.b.a.cJ(3, this.Zlb) + i.a.a.b.b.a.cJ(4, this.Zlc) + i.a.a.a.c(5, 8, this.Zld) + i.a.a.a.c(6, 8, this.Zle) + i.a.a.a.c(7, 8, this.Zlf) + i.a.a.b.b.a.cJ(8, this.Zlg) + i.a.a.b.b.a.cJ(9, this.Zlh) + i.a.a.b.b.a.cJ(10, this.Zli);
      paramInt = i;
      if (this.Zlj != null) {
        paramInt = i + i.a.a.a.qC(11, this.Zlj.computeSize());
      }
      AppMethodBeat.o(143970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zld.clear();
      this.Zle.clear();
      this.Zlf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      acq localacq = (acq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143970);
        return -1;
      case 1: 
        localacq.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 2: 
        localacq.Zla = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 3: 
        localacq.Zlb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 4: 
        localacq.Zlc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localacq.Zld.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localacq.Zle.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fjn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fjn)localObject2).parseFrom((byte[])localObject1);
          }
          localacq.Zlf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 8: 
        localacq.Zlg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 9: 
        localacq.Zlh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      case 10: 
        localacq.Zli = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(143970);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new czq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((czq)localObject2).parseFrom((byte[])localObject1);
        }
        localacq.Zlj = ((czq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    AppMethodBeat.o(143970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */