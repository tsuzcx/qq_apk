package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.cd.a
{
  public String BDX;
  public String Hnf;
  public al Hng;
  public LinkedList<al> Hnh;
  public LinkedList<al> Hni;
  public LinkedList<al> Hnj;
  public String Hnk;
  public String Hnl;
  public LinkedList<ak> Hnm;
  public LinkedList<ak> Hnn;
  public av Hno;
  public String charset;
  public String content;
  public int size;
  
  public am()
  {
    AppMethodBeat.i(251238);
    this.Hnh = new LinkedList();
    this.Hni = new LinkedList();
    this.Hnj = new LinkedList();
    this.Hnm = new LinkedList();
    this.Hnn = new LinkedList();
    AppMethodBeat.o(251238);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.size);
      if (this.charset != null) {
        paramVarArgs.f(2, this.charset);
      }
      if (this.Hnf != null) {
        paramVarArgs.f(3, this.Hnf);
      }
      if (this.Hng != null)
      {
        paramVarArgs.oE(4, this.Hng.computeSize());
        this.Hng.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Hnh);
      paramVarArgs.e(6, 8, this.Hni);
      paramVarArgs.e(7, 8, this.Hnj);
      if (this.Hnk != null) {
        paramVarArgs.f(8, this.Hnk);
      }
      if (this.BDX != null) {
        paramVarArgs.f(9, this.BDX);
      }
      if (this.Hnl != null) {
        paramVarArgs.f(10, this.Hnl);
      }
      if (this.content != null) {
        paramVarArgs.f(11, this.content);
      }
      paramVarArgs.e(12, 8, this.Hnm);
      paramVarArgs.e(13, 8, this.Hnn);
      if (this.Hno != null)
      {
        paramVarArgs.oE(14, this.Hno.computeSize());
        this.Hno.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(251244);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.size) + 0;
      paramInt = i;
      if (this.charset != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.charset);
      }
      i = paramInt;
      if (this.Hnf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Hnf);
      }
      paramInt = i;
      if (this.Hng != null) {
        paramInt = i + g.a.a.a.oD(4, this.Hng.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.Hnh) + g.a.a.a.c(6, 8, this.Hni) + g.a.a.a.c(7, 8, this.Hnj);
      paramInt = i;
      if (this.Hnk != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Hnk);
      }
      i = paramInt;
      if (this.BDX != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.BDX);
      }
      paramInt = i;
      if (this.Hnl != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Hnl);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.content);
      }
      i = i + g.a.a.a.c(12, 8, this.Hnm) + g.a.a.a.c(13, 8, this.Hnn);
      paramInt = i;
      if (this.Hno != null) {
        paramInt = i + g.a.a.a.oD(14, this.Hno.computeSize());
      }
      AppMethodBeat.o(251244);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hnh.clear();
      this.Hni.clear();
      this.Hnj.clear();
      this.Hnm.clear();
      this.Hnn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(251244);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(251244);
        return -1;
      case 1: 
        localam.size = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(251244);
        return 0;
      case 2: 
        localam.charset = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 3: 
        localam.Hnf = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hng = ((al)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hnh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hni.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hnj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      case 8: 
        localam.Hnk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 9: 
        localam.BDX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 10: 
        localam.Hnl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 11: 
        localam.content = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(251244);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hnm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localam.Hnn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251244);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new av();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((av)localObject2).parseFrom((byte[])localObject1);
        }
        localam.Hno = ((av)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(251244);
      return 0;
    }
    AppMethodBeat.o(251244);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.am
 * JD-Core Version:    0.7.0.1
 */