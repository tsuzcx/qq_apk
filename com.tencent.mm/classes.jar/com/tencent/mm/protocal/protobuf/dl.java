package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class dl
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int IIs;
  public int Njs;
  public long Njv;
  public etl YFE;
  public etl YFF;
  public etl YFG;
  public int YFH;
  public gol YFI;
  public String YFJ;
  public String YFK;
  public int YFL;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.YFG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Njs);
      if (this.YFE != null)
      {
        paramVarArgs.qD(2, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(3, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.IIs);
      if (this.YFG != null)
      {
        paramVarArgs.qD(5, this.YFG.computeSize());
        this.YFG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.vhk);
      paramVarArgs.bS(7, this.YFH);
      if (this.YFI != null)
      {
        paramVarArgs.qD(8, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.CreateTime);
      if (this.YFJ != null) {
        paramVarArgs.g(10, this.YFJ);
      }
      if (this.YFK != null) {
        paramVarArgs.g(11, this.YFK);
      }
      paramVarArgs.bv(12, this.Njv);
      paramVarArgs.bS(13, this.YFL);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Njs) + 0;
      paramInt = i;
      if (this.YFE != null) {
        paramInt = i + i.a.a.a.qC(2, this.YFE.computeSize());
      }
      i = paramInt;
      if (this.YFF != null) {
        i = paramInt + i.a.a.a.qC(3, this.YFF.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.IIs);
      paramInt = i;
      if (this.YFG != null) {
        paramInt = i + i.a.a.a.qC(5, this.YFG.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.vhk) + i.a.a.b.b.a.cJ(7, this.YFH);
      paramInt = i;
      if (this.YFI != null) {
        paramInt = i + i.a.a.a.qC(8, this.YFI.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.CreateTime);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YFJ);
      }
      i = paramInt;
      if (this.YFK != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YFK);
      }
      paramInt = i.a.a.b.b.a.q(12, this.Njv);
      int j = i.a.a.b.b.a.cJ(13, this.YFL);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.YFG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dl localdl = (dl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localdl.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localdl.YFE = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localdl.YFF = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localdl.IIs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localdl.YFG = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localdl.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localdl.YFH = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localdl.YFI = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localdl.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localdl.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localdl.YFK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localdl.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(133143);
        return 0;
      }
      localdl.YFL = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dl
 * JD-Core Version:    0.7.0.1
 */