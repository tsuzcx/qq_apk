package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String FWL;
  public int NPm;
  public String NPn;
  public String NPo;
  public String NPp;
  public long NPq;
  public int NPr;
  public h NPs;
  public String NPt;
  public String NPu;
  public String NPv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.NPm);
      if (this.NPn != null) {
        paramVarArgs.d(2, this.NPn);
      }
      if (this.NPo != null) {
        paramVarArgs.d(3, this.NPo);
      }
      if (this.NPp != null) {
        paramVarArgs.d(5, this.NPp);
      }
      paramVarArgs.aY(6, this.NPq);
      if (this.FWL != null) {
        paramVarArgs.d(7, this.FWL);
      }
      paramVarArgs.aS(8, this.NPr);
      if (this.NPs != null)
      {
        paramVarArgs.lC(9, this.NPs.computeSize());
        this.NPs.writeFields(paramVarArgs);
      }
      if (this.NPt != null) {
        paramVarArgs.d(10, this.NPt);
      }
      if (this.NPu != null) {
        paramVarArgs.d(11, this.NPu);
      }
      if (this.NPv != null) {
        paramVarArgs.d(12, this.NPv);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.NPm) + 0;
      paramInt = i;
      if (this.NPn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.NPn);
      }
      i = paramInt;
      if (this.NPo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.NPo);
      }
      paramInt = i;
      if (this.NPp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.NPp);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.NPq);
      paramInt = i;
      if (this.FWL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWL);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.NPr);
      paramInt = i;
      if (this.NPs != null) {
        paramInt = i + f.a.a.a.lB(9, this.NPs.computeSize());
      }
      i = paramInt;
      if (this.NPt != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.NPt);
      }
      paramInt = i;
      if (this.NPu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.NPu);
      }
      i = paramInt;
      if (this.NPv != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.NPv);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.NPm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.NPn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.NPo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.NPp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.NPq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.FWL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.NPr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.NPs = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.NPt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.NPu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.NPv = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91742);
      return 0;
    }
    AppMethodBeat.o(91742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.d
 * JD-Core Version:    0.7.0.1
 */