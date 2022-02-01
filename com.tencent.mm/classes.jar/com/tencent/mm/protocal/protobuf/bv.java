package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bv
  extends com.tencent.mm.bx.a
{
  public String YDA;
  public String YDB;
  public LinkedList<bw> YDC;
  public int end_time;
  public int ftu;
  
  public bv()
  {
    AppMethodBeat.i(259472);
    this.YDC = new LinkedList();
    AppMethodBeat.o(259472);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YDA != null) {
        paramVarArgs.g(1, this.YDA);
      }
      if (this.YDB != null) {
        paramVarArgs.g(2, this.YDB);
      }
      paramVarArgs.bS(3, this.ftu);
      paramVarArgs.bS(4, this.end_time);
      paramVarArgs.e(5, 8, this.YDC);
      AppMethodBeat.o(259477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YDA == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.b.b.a.h(1, this.YDA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YDB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YDB);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ftu);
      int j = i.a.a.b.b.a.cJ(4, this.end_time);
      int k = i.a.a.a.c(5, 8, this.YDC);
      AppMethodBeat.o(259477);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YDC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259477);
          return -1;
        case 1: 
          localbv.YDA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259477);
          return 0;
        case 2: 
          localbv.YDB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259477);
          return 0;
        case 3: 
          localbv.ftu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259477);
          return 0;
        case 4: 
          localbv.end_time = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259477);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bw localbw = new bw();
          if ((localObject != null) && (localObject.length > 0)) {
            localbw.parseFrom((byte[])localObject);
          }
          localbv.YDC.add(localbw);
          paramInt += 1;
        }
        AppMethodBeat.o(259477);
        return 0;
      }
      AppMethodBeat.o(259477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bv
 * JD-Core Version:    0.7.0.1
 */