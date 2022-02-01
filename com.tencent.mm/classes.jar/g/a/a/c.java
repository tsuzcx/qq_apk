package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String Zsq;
  public String ZvS;
  public LinkedList<i> ZvT;
  public int ZvU;
  public a ZvV;
  public int ajFA;
  public int ajFB;
  public f ajFC;
  public String ajFD;
  public b ajFE;
  public d ajFF;
  public int ajFz;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.ZvT = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZvT);
      paramVarArgs.bS(2, this.ajFz);
      if (this.Zsq != null) {
        paramVarArgs.g(3, this.Zsq);
      }
      paramVarArgs.bS(4, this.ZvU);
      if (this.ZvV != null)
      {
        paramVarArgs.qD(5, this.ZvV.computeSize());
        this.ZvV.writeFields(paramVarArgs);
      }
      if (this.ZvS != null) {
        paramVarArgs.g(6, this.ZvS);
      }
      paramVarArgs.bS(7, this.ajFA);
      paramVarArgs.bS(8, this.ajFB);
      if (this.ajFC != null)
      {
        paramVarArgs.qD(9, this.ajFC.computeSize());
        this.ajFC.writeFields(paramVarArgs);
      }
      if (this.ajFD != null) {
        paramVarArgs.g(10, this.ajFD);
      }
      if (this.ajFE != null)
      {
        paramVarArgs.qD(11, this.ajFE.computeSize());
        this.ajFE.writeFields(paramVarArgs);
      }
      if (this.ajFF != null)
      {
        paramVarArgs.qD(12, this.ajFF.computeSize());
        this.ajFF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZvT) + 0 + i.a.a.b.b.a.cJ(2, this.ajFz);
      paramInt = i;
      if (this.Zsq != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zsq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZvU);
      paramInt = i;
      if (this.ZvV != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZvV.computeSize());
      }
      i = paramInt;
      if (this.ZvS != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZvS);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.ajFA) + i.a.a.b.b.a.cJ(8, this.ajFB);
      paramInt = i;
      if (this.ajFC != null) {
        paramInt = i + i.a.a.a.qC(9, this.ajFC.computeSize());
      }
      i = paramInt;
      if (this.ajFD != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ajFD);
      }
      paramInt = i;
      if (this.ajFE != null) {
        paramInt = i + i.a.a.a.qC(11, this.ajFE.computeSize());
      }
      i = paramInt;
      if (this.ajFF != null) {
        i = paramInt + i.a.a.a.qC(12, this.ajFF.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZvT.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91741);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new i();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((i)localObject2).parseFrom((byte[])localObject1);
          }
          localc.ZvT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.ajFz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.Zsq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.ZvU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localc.ZvV = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.ZvS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.ajFA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.ajFB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          localc.ajFC = ((f)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.ajFD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localc.ajFE = ((b)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new d();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((d)localObject2).parseFrom((byte[])localObject1);
        }
        localc.ajFF = ((d)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    AppMethodBeat.o(91741);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.c
 * JD-Core Version:    0.7.0.1
 */