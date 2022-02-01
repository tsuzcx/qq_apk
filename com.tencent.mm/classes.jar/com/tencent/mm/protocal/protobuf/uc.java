package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uc
  extends com.tencent.mm.cd.a
{
  public String RFf;
  public String Seb;
  public String Sec;
  public String Sed;
  public String See;
  public String Sef;
  public LinkedList<ub> Seg;
  public int Seh;
  public String Sei;
  public String Sej;
  public String Sek;
  public int Sel;
  public String Sem;
  public int Sen;
  public String Seo;
  public int Sep;
  public String Seq;
  public up Ser;
  public String Ses;
  public String Set;
  
  public uc()
  {
    AppMethodBeat.i(113951);
    this.Seg = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFf != null) {
        paramVarArgs.f(1, this.RFf);
      }
      if (this.Seb != null) {
        paramVarArgs.f(2, this.Seb);
      }
      if (this.Sec != null) {
        paramVarArgs.f(3, this.Sec);
      }
      if (this.Sed != null) {
        paramVarArgs.f(4, this.Sed);
      }
      if (this.See != null) {
        paramVarArgs.f(5, this.See);
      }
      if (this.Sef != null) {
        paramVarArgs.f(6, this.Sef);
      }
      paramVarArgs.e(7, 8, this.Seg);
      paramVarArgs.aY(8, this.Seh);
      if (this.Sei != null) {
        paramVarArgs.f(9, this.Sei);
      }
      if (this.Sej != null) {
        paramVarArgs.f(10, this.Sej);
      }
      if (this.Sek != null) {
        paramVarArgs.f(11, this.Sek);
      }
      paramVarArgs.aY(12, this.Sel);
      if (this.Sem != null) {
        paramVarArgs.f(13, this.Sem);
      }
      paramVarArgs.aY(14, this.Sen);
      if (this.Seo != null) {
        paramVarArgs.f(15, this.Seo);
      }
      paramVarArgs.aY(16, this.Sep);
      if (this.Seq != null) {
        paramVarArgs.f(17, this.Seq);
      }
      if (this.Ser != null)
      {
        paramVarArgs.oE(18, this.Ser.computeSize());
        this.Ser.writeFields(paramVarArgs);
      }
      if (this.Ses != null) {
        paramVarArgs.f(19, this.Ses);
      }
      if (this.Set != null) {
        paramVarArgs.f(20, this.Set);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFf == null) {
        break label1450;
      }
    }
    label1450:
    for (int i = g.a.a.b.b.a.g(1, this.RFf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Seb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Seb);
      }
      i = paramInt;
      if (this.Sec != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sec);
      }
      paramInt = i;
      if (this.Sed != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sed);
      }
      i = paramInt;
      if (this.See != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.See);
      }
      paramInt = i;
      if (this.Sef != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sef);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Seg) + g.a.a.b.b.a.bM(8, this.Seh);
      paramInt = i;
      if (this.Sei != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sei);
      }
      i = paramInt;
      if (this.Sej != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Sej);
      }
      paramInt = i;
      if (this.Sek != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Sek);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Sel);
      paramInt = i;
      if (this.Sem != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Sem);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.Sen);
      paramInt = i;
      if (this.Seo != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.Seo);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.Sep);
      paramInt = i;
      if (this.Seq != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Seq);
      }
      i = paramInt;
      if (this.Ser != null) {
        i = paramInt + g.a.a.a.oD(18, this.Ser.computeSize());
      }
      paramInt = i;
      if (this.Ses != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.Ses);
      }
      i = paramInt;
      if (this.Set != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.Set);
      }
      AppMethodBeat.o(113952);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Seg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        uc localuc = (uc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localuc.RFf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localuc.Seb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localuc.Sec = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localuc.Sed = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localuc.See = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localuc.Sef = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ub();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ub)localObject2).parseFrom((byte[])localObject1);
            }
            localuc.Seg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localuc.Seh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localuc.Sei = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localuc.Sej = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localuc.Sek = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localuc.Sel = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localuc.Sem = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localuc.Sen = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localuc.Seo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localuc.Sep = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localuc.Seq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localuc.Ser = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 19: 
          localuc.Ses = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113952);
          return 0;
        }
        localuc.Set = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uc
 * JD-Core Version:    0.7.0.1
 */