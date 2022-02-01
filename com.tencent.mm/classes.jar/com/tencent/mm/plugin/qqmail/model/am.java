package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bx.a
{
  public String Hox;
  public LinkedList<ak> NkV;
  public LinkedList<ak> NkW;
  public LinkedList<ak> NkX;
  public int Nld;
  public ak Nle;
  public LinkedList<aj> Nlf;
  public LinkedList<aj> Nlg;
  public String Nlh;
  public boolean Nli;
  public String content;
  
  public am()
  {
    AppMethodBeat.i(267037);
    this.NkV = new LinkedList();
    this.NkW = new LinkedList();
    this.NkX = new LinkedList();
    this.Nlf = new LinkedList();
    this.Nlg = new LinkedList();
    AppMethodBeat.o(267037);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Nld);
      if (this.Nle != null)
      {
        paramVarArgs.qD(2, this.Nle.computeSize());
        this.Nle.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.NkV);
      paramVarArgs.e(4, 8, this.NkW);
      paramVarArgs.e(5, 8, this.NkX);
      if (this.Hox != null) {
        paramVarArgs.g(6, this.Hox);
      }
      if (this.content != null) {
        paramVarArgs.g(7, this.content);
      }
      paramVarArgs.e(8, 8, this.Nlf);
      paramVarArgs.e(9, 8, this.Nlg);
      if (this.Nlh != null) {
        paramVarArgs.g(10, this.Nlh);
      }
      paramVarArgs.di(11, this.Nli);
      AppMethodBeat.o(267049);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Nld) + 0;
      paramInt = i;
      if (this.Nle != null) {
        paramInt = i + i.a.a.a.qC(2, this.Nle.computeSize());
      }
      i = paramInt + i.a.a.a.c(3, 8, this.NkV) + i.a.a.a.c(4, 8, this.NkW) + i.a.a.a.c(5, 8, this.NkX);
      paramInt = i;
      if (this.Hox != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Hox);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.content);
      }
      i = i + i.a.a.a.c(8, 8, this.Nlf) + i.a.a.a.c(9, 8, this.Nlg);
      paramInt = i;
      if (this.Nlh != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Nlh);
      }
      i = i.a.a.b.b.a.ko(11);
      AppMethodBeat.o(267049);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NkV.clear();
      this.NkW.clear();
      this.NkX.clear();
      this.Nlf.clear();
      this.Nlg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(267049);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(267049);
        return -1;
      case 1: 
        localam.Nld = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(267049);
        return 0;
      case 2: 
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
          localam.Nle = ((ak)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
        return 0;
      case 3: 
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
          localam.NkV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
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
          localam.NkW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
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
          localam.NkX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
        return 0;
      case 6: 
        localam.Hox = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267049);
        return 0;
      case 7: 
        localam.content = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267049);
        return 0;
      case 8: 
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
          localam.Nlf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
        return 0;
      case 9: 
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
          localam.Nlg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267049);
        return 0;
      case 10: 
        localam.Nlh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(267049);
        return 0;
      }
      localam.Nli = ((i.a.a.a.a)localObject1).ajGk.aai();
      AppMethodBeat.o(267049);
      return 0;
    }
    AppMethodBeat.o(267049);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.am
 * JD-Core Version:    0.7.0.1
 */