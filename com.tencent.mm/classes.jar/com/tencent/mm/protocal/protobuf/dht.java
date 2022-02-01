package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dht
  extends com.tencent.mm.bw.a
{
  public String EJR;
  public String Ecm;
  public int Eqy;
  public int FDp;
  public LinkedList<dhs> FQK;
  public boolean FQL;
  public LinkedList<dhv> FQM;
  public String FQN;
  public String Md5;
  public int Version;
  public int ndI;
  
  public dht()
  {
    AppMethodBeat.i(6438);
    this.FQK = new LinkedList();
    this.FQM = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      paramVarArgs.aR(2, this.Version);
      if (this.Ecm != null) {
        paramVarArgs.d(3, this.Ecm);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aR(5, this.Eqy);
      paramVarArgs.aR(6, this.FDp);
      paramVarArgs.e(7, 8, this.FQK);
      paramVarArgs.bl(8, this.FQL);
      if (this.EJR != null) {
        paramVarArgs.d(9, this.EJR);
      }
      paramVarArgs.e(10, 8, this.FQM);
      if (this.FQN != null) {
        paramVarArgs.d(11, this.FQN);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0 + f.a.a.b.b.a.bx(2, this.Version);
      paramInt = i;
      if (this.Ecm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ecm);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = i + f.a.a.b.b.a.bx(5, this.Eqy) + f.a.a.b.b.a.bx(6, this.FDp) + f.a.a.a.c(7, 8, this.FQK) + (f.a.a.b.b.a.fK(8) + 1);
      paramInt = i;
      if (this.EJR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EJR);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.FQM);
      paramInt = i;
      if (this.FQN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FQN);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FQK.clear();
      this.FQM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dht localdht = (dht)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localdht.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localdht.Version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localdht.Ecm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localdht.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localdht.Eqy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localdht.FDp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdht.FQK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localdht.FQL = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localdht.EJR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdht.FQM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localdht.FQN = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dht
 * JD-Core Version:    0.7.0.1
 */