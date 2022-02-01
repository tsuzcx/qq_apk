package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eib
  extends com.tencent.mm.bw.a
{
  public String KUA;
  public String LQx;
  public int Lla;
  public int MSm;
  public String Md5;
  public LinkedList<eia> Nhn;
  public boolean Nho;
  public LinkedList<eid> Nhp;
  public String Nhq;
  public int Version;
  public int oUv;
  
  public eib()
  {
    AppMethodBeat.i(6438);
    this.Nhn = new LinkedList();
    this.Nhp = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      paramVarArgs.aM(2, this.Version);
      if (this.KUA != null) {
        paramVarArgs.e(3, this.KUA);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(4, this.Md5);
      }
      paramVarArgs.aM(5, this.Lla);
      paramVarArgs.aM(6, this.MSm);
      paramVarArgs.e(7, 8, this.Nhn);
      paramVarArgs.cc(8, this.Nho);
      if (this.LQx != null) {
        paramVarArgs.e(9, this.LQx);
      }
      paramVarArgs.e(10, 8, this.Nhp);
      if (this.Nhq != null) {
        paramVarArgs.e(11, this.Nhq);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.b.b.a.bu(2, this.Version);
      paramInt = i;
      if (this.KUA != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KUA);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Md5);
      }
      i = i + g.a.a.b.b.a.bu(5, this.Lla) + g.a.a.b.b.a.bu(6, this.MSm) + g.a.a.a.c(7, 8, this.Nhn) + (g.a.a.b.b.a.fS(8) + 1);
      paramInt = i;
      if (this.LQx != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LQx);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.Nhp);
      paramInt = i;
      if (this.Nhq != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Nhq);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nhn.clear();
      this.Nhp.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eib localeib = (eib)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localeib.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localeib.Version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localeib.KUA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localeib.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localeib.Lla = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localeib.MSm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eia();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eia)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeib.Nhn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localeib.Nho = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localeib.LQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eid();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eid)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeib.Nhp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localeib.Nhq = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eib
 * JD-Core Version:    0.7.0.1
 */