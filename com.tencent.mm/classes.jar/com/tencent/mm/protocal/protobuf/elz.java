package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elz
  extends com.tencent.mm.cd.a
{
  public int UnZ;
  public int Uoa;
  public int Uob;
  public fdb Uoc;
  public int Uod;
  public int Uoe;
  public int Uof;
  public int Uog;
  public LinkedList<Integer> Uoh;
  public int Uoi;
  public LinkedList<Integer> Uoj;
  public int Uok;
  public LinkedList<Integer> Uol;
  public String Uom;
  
  public elz()
  {
    AppMethodBeat.i(115851);
    this.Uoh = new LinkedList();
    this.Uoj = new LinkedList();
    this.Uol = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uoc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.UnZ);
      paramVarArgs.aY(2, this.Uoa);
      paramVarArgs.aY(3, this.Uob);
      if (this.Uoc != null)
      {
        paramVarArgs.oE(4, this.Uoc.computeSize());
        this.Uoc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Uod);
      paramVarArgs.aY(6, this.Uoe);
      paramVarArgs.aY(7, this.Uof);
      paramVarArgs.aY(8, this.Uog);
      paramVarArgs.f(9, 2, this.Uoh);
      paramVarArgs.aY(10, this.Uoi);
      paramVarArgs.f(11, 2, this.Uoj);
      paramVarArgs.aY(12, this.Uok);
      paramVarArgs.f(13, 2, this.Uol);
      if (this.Uom != null) {
        paramVarArgs.f(14, this.Uom);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UnZ) + 0 + g.a.a.b.b.a.bM(2, this.Uoa) + g.a.a.b.b.a.bM(3, this.Uob);
      paramInt = i;
      if (this.Uoc != null) {
        paramInt = i + g.a.a.a.oD(4, this.Uoc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Uod) + g.a.a.b.b.a.bM(6, this.Uoe) + g.a.a.b.b.a.bM(7, this.Uof) + g.a.a.b.b.a.bM(8, this.Uog) + g.a.a.a.d(9, 2, this.Uoh) + g.a.a.b.b.a.bM(10, this.Uoi) + g.a.a.a.d(11, 2, this.Uoj) + g.a.a.b.b.a.bM(12, this.Uok) + g.a.a.a.d(13, 2, this.Uol);
      paramInt = i;
      if (this.Uom != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Uom);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uoh.clear();
      this.Uoj.clear();
      this.Uol.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Uoc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      elz localelz = (elz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localelz.UnZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localelz.Uoa = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localelz.Uob = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fdb localfdb = new fdb();
          if ((localObject != null) && (localObject.length > 0)) {
            localfdb.parseFrom((byte[])localObject);
          }
          localelz.Uoc = localfdb;
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localelz.Uod = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localelz.Uoe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localelz.Uof = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localelz.Uog = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localelz.Uoh = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localelz.Uoi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localelz.Uoj = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localelz.Uok = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localelz.Uol = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(115852);
        return 0;
      }
      localelz.Uom = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elz
 * JD-Core Version:    0.7.0.1
 */