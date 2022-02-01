package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctd
  extends com.tencent.mm.bw.a
{
  public String HEf;
  public LinkedList<dka> HEg;
  public String HEh;
  public String HEi;
  public String HEj;
  public ctb HEk;
  public String description;
  public String hCo;
  public String hCp;
  public String hCq;
  public int oGc;
  public String title;
  
  public ctd()
  {
    AppMethodBeat.i(168759);
    this.HEg = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hCp != null) {
        paramVarArgs.d(2, this.hCp);
      }
      if (this.hCq != null) {
        paramVarArgs.d(3, this.hCq);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      if (this.HEf != null) {
        paramVarArgs.d(9, this.HEf);
      }
      paramVarArgs.e(10, 8, this.HEg);
      paramVarArgs.aS(11, this.oGc);
      if (this.HEh != null) {
        paramVarArgs.d(12, this.HEh);
      }
      if (this.HEi != null) {
        paramVarArgs.d(13, this.HEi);
      }
      if (this.HEj != null) {
        paramVarArgs.d(14, this.HEj);
      }
      if (this.hCo != null) {
        paramVarArgs.d(15, this.hCo);
      }
      if (this.HEk != null)
      {
        paramVarArgs.lJ(16, this.HEk.computeSize());
        this.HEk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCp);
      }
      i = paramInt;
      if (this.hCq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCq);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      i = paramInt;
      if (this.HEf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HEf);
      }
      i = i + f.a.a.a.c(10, 8, this.HEg) + f.a.a.b.b.a.bz(11, this.oGc);
      paramInt = i;
      if (this.HEh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HEh);
      }
      i = paramInt;
      if (this.HEi != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HEi);
      }
      paramInt = i;
      if (this.HEj != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HEj);
      }
      i = paramInt;
      if (this.hCo != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.hCo);
      }
      paramInt = i;
      if (this.HEk != null) {
        paramInt = i + f.a.a.a.lI(16, this.HEk.computeSize());
      }
      AppMethodBeat.o(168760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HEg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctd localctd = (ctd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localctd.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localctd.hCp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localctd.hCq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localctd.description = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localctd.HEf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dka();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dka)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctd.HEg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localctd.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localctd.HEh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localctd.HEi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localctd.HEj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localctd.hCo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctd.HEk = ((ctb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctd
 * JD-Core Version:    0.7.0.1
 */