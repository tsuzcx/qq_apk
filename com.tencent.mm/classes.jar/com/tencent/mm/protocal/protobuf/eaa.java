package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaa
  extends com.tencent.mm.cd.a
{
  public LinkedList<ahr> Srt;
  public erw Ufp;
  public ahq Ufq;
  public int Ufr;
  public boolean Ufs;
  public aey Uft;
  public bh Ufu;
  public int type;
  public String url;
  
  public eaa()
  {
    AppMethodBeat.i(91676);
    this.Srt = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.Ufp != null)
      {
        paramVarArgs.oE(3, this.Ufp.computeSize());
        this.Ufp.writeFields(paramVarArgs);
      }
      if (this.Ufq != null)
      {
        paramVarArgs.oE(4, this.Ufq.computeSize());
        this.Ufq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Ufr);
      paramVarArgs.co(6, this.Ufs);
      paramVarArgs.e(7, 8, this.Srt);
      if (this.Uft != null)
      {
        paramVarArgs.oE(8, this.Uft.computeSize());
        this.Uft.writeFields(paramVarArgs);
      }
      if (this.Ufu != null)
      {
        paramVarArgs.oE(9, this.Ufu.computeSize());
        this.Ufu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.Ufp != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ufp.computeSize());
      }
      paramInt = i;
      if (this.Ufq != null) {
        paramInt = i + g.a.a.a.oD(4, this.Ufq.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Ufr) + (g.a.a.b.b.a.gL(6) + 1) + g.a.a.a.c(7, 8, this.Srt);
      paramInt = i;
      if (this.Uft != null) {
        paramInt = i + g.a.a.a.oD(8, this.Uft.computeSize());
      }
      i = paramInt;
      if (this.Ufu != null) {
        i = paramInt + g.a.a.a.oD(9, this.Ufu.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Srt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eaa localeaa = (eaa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localeaa.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localeaa.url = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erw)localObject2).parseFrom((byte[])localObject1);
          }
          localeaa.Ufp = ((erw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahq)localObject2).parseFrom((byte[])localObject1);
          }
          localeaa.Ufq = ((ahq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localeaa.Ufr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localeaa.Ufs = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahr)localObject2).parseFrom((byte[])localObject1);
          }
          localeaa.Srt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aey();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aey)localObject2).parseFrom((byte[])localObject1);
          }
          localeaa.Uft = ((aey)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bh();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bh)localObject2).parseFrom((byte[])localObject1);
        }
        localeaa.Ufu = ((bh)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaa
 * JD-Core Version:    0.7.0.1
 */