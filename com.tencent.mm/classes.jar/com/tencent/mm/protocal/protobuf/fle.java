package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fle
  extends com.tencent.mm.bx.a
{
  public String YVH;
  public LinkedList<flf> YVI;
  public long YVJ;
  public String Zxn;
  public String Zxo;
  public flg abLF;
  public fli abLG;
  
  public fle()
  {
    AppMethodBeat.i(124556);
    this.YVI = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zxn != null) {
        paramVarArgs.g(1, this.Zxn);
      }
      if (this.abLF != null)
      {
        paramVarArgs.qD(2, this.abLF.computeSize());
        this.abLF.writeFields(paramVarArgs);
      }
      if (this.YVH != null) {
        paramVarArgs.g(3, this.YVH);
      }
      paramVarArgs.e(4, 8, this.YVI);
      if (this.Zxo != null) {
        paramVarArgs.g(5, this.Zxo);
      }
      paramVarArgs.bv(6, this.YVJ);
      if (this.abLG != null)
      {
        paramVarArgs.qD(7, this.abLG.computeSize());
        this.abLG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zxn == null) {
        break label764;
      }
    }
    label764:
    for (int i = i.a.a.b.b.a.h(1, this.Zxn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abLF != null) {
        paramInt = i + i.a.a.a.qC(2, this.abLF.computeSize());
      }
      i = paramInt;
      if (this.YVH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YVH);
      }
      i += i.a.a.a.c(4, 8, this.YVI);
      paramInt = i;
      if (this.Zxo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zxo);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.YVJ);
      paramInt = i;
      if (this.abLG != null) {
        paramInt = i + i.a.a.a.qC(7, this.abLG.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YVI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fle localfle = (fle)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localfle.Zxn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flg)localObject2).parseFrom((byte[])localObject1);
            }
            localfle.abLF = ((flg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localfle.YVH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flf)localObject2).parseFrom((byte[])localObject1);
            }
            localfle.YVI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localfle.Zxo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localfle.YVJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fli();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fli)localObject2).parseFrom((byte[])localObject1);
          }
          localfle.abLG = ((fli)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fle
 * JD-Core Version:    0.7.0.1
 */