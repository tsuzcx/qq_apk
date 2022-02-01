package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.cd.a
{
  public String BDX;
  public int HlJ;
  public LinkedList<l> HlK;
  public LinkedList<l> HlL;
  public LinkedList<l> HlM;
  public LinkedList<aj> HlN;
  public int HlO;
  public String Hls;
  public String content;
  
  public i()
  {
    AppMethodBeat.i(122665);
    this.HlK = new LinkedList();
    this.HlL = new LinkedList();
    this.HlM = new LinkedList();
    this.HlN = new LinkedList();
    this.HlO = 20;
    AppMethodBeat.o(122665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.HlJ);
      if (this.Hls != null) {
        paramVarArgs.f(2, this.Hls);
      }
      paramVarArgs.e(3, 8, this.HlK);
      paramVarArgs.e(4, 8, this.HlL);
      paramVarArgs.e(5, 8, this.HlM);
      paramVarArgs.e(6, 8, this.HlN);
      if (this.BDX != null) {
        paramVarArgs.f(7, this.BDX);
      }
      if (this.content != null) {
        paramVarArgs.f(8, this.content);
      }
      paramVarArgs.aY(9, this.HlO);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.HlJ) + 0;
      paramInt = i;
      if (this.Hls != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Hls);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.HlK) + g.a.a.a.c(4, 8, this.HlL) + g.a.a.a.c(5, 8, this.HlM) + g.a.a.a.c(6, 8, this.HlN);
      paramInt = i;
      if (this.BDX != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.BDX);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.content);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.HlO);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HlK.clear();
      this.HlL.clear();
      this.HlM.clear();
      this.HlN.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122666);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122666);
        return -1;
      case 1: 
        locali.HlJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        locali.Hls = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new l();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((l)localObject2).parseFrom((byte[])localObject1);
          }
          locali.HlK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new l();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((l)localObject2).parseFrom((byte[])localObject1);
          }
          locali.HlL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new l();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((l)localObject2).parseFrom((byte[])localObject1);
          }
          locali.HlM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aj)localObject2).parseFrom((byte[])localObject1);
          }
          locali.HlN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        locali.BDX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        locali.content = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      locali.HlO = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.i
 * JD-Core Version:    0.7.0.1
 */