package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class al
  extends com.tencent.mm.bx.a
{
  public String Hox;
  public String NkT;
  public ak NkU;
  public LinkedList<ak> NkV;
  public LinkedList<ak> NkW;
  public LinkedList<ak> NkX;
  public String NkY;
  public String NkZ;
  public LinkedList<aj> Nla;
  public LinkedList<aj> Nlb;
  public au Nlc;
  public String charset;
  public String content;
  public int size;
  
  public al()
  {
    AppMethodBeat.i(267041);
    this.NkV = new LinkedList();
    this.NkW = new LinkedList();
    this.NkX = new LinkedList();
    this.Nla = new LinkedList();
    this.Nlb = new LinkedList();
    AppMethodBeat.o(267041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267051);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.size);
      if (this.charset != null) {
        paramVarArgs.g(2, this.charset);
      }
      if (this.NkT != null) {
        paramVarArgs.g(3, this.NkT);
      }
      if (this.NkU != null)
      {
        paramVarArgs.qD(4, this.NkU.computeSize());
        this.NkU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.NkV);
      paramVarArgs.e(6, 8, this.NkW);
      paramVarArgs.e(7, 8, this.NkX);
      if (this.NkY != null) {
        paramVarArgs.g(8, this.NkY);
      }
      if (this.Hox != null) {
        paramVarArgs.g(9, this.Hox);
      }
      if (this.NkZ != null) {
        paramVarArgs.g(10, this.NkZ);
      }
      if (this.content != null) {
        paramVarArgs.g(11, this.content);
      }
      paramVarArgs.e(12, 8, this.Nla);
      paramVarArgs.e(13, 8, this.Nlb);
      if (this.Nlc != null)
      {
        paramVarArgs.qD(14, this.Nlc.computeSize());
        this.Nlc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(267051);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.size) + 0;
      paramInt = i;
      if (this.charset != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.charset);
      }
      i = paramInt;
      if (this.NkT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.NkT);
      }
      paramInt = i;
      if (this.NkU != null) {
        paramInt = i + i.a.a.a.qC(4, this.NkU.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.NkV) + i.a.a.a.c(6, 8, this.NkW) + i.a.a.a.c(7, 8, this.NkX);
      paramInt = i;
      if (this.NkY != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.NkY);
      }
      i = paramInt;
      if (this.Hox != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Hox);
      }
      paramInt = i;
      if (this.NkZ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.NkZ);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.content);
      }
      i = i + i.a.a.a.c(12, 8, this.Nla) + i.a.a.a.c(13, 8, this.Nlb);
      paramInt = i;
      if (this.Nlc != null) {
        paramInt = i + i.a.a.a.qC(14, this.Nlc.computeSize());
      }
      AppMethodBeat.o(267051);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NkV.clear();
      this.NkW.clear();
      this.NkX.clear();
      this.Nla.clear();
      this.Nlb.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(267051);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      al localal = (al)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(267051);
        return -1;
      case 1: 
        localal.size = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(267051);
        return 0;
      case 2: 
        localal.charset = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 3: 
        localal.NkT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localal.NkU = ((ak)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localal.NkV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localal.NkW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localal.NkX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      case 8: 
        localal.NkY = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 9: 
        localal.Hox = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 10: 
        localal.NkZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 11: 
        localal.content = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267051);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aj)localObject2).parseFrom((byte[])localObject1);
          }
          localal.Nla.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aj)localObject2).parseFrom((byte[])localObject1);
          }
          localal.Nlb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267051);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new au();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((au)localObject2).parseFrom((byte[])localObject1);
        }
        localal.Nlc = ((au)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(267051);
      return 0;
    }
    AppMethodBeat.o(267051);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.al
 * JD-Core Version:    0.7.0.1
 */