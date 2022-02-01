package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apx
  extends com.tencent.mm.bx.a
{
  public int YFu;
  public LinkedList<qo> YSB;
  public String YSF;
  public String YSJ;
  public LinkedList<String> YVA;
  public int YVB;
  public long YVJ;
  public String Zxn;
  public String Zxo;
  public String Zxp;
  public String Zxq;
  public String Zxr;
  
  public apx()
  {
    AppMethodBeat.i(259390);
    this.YSB = new LinkedList();
    this.YVA = new LinkedList();
    AppMethodBeat.o(259390);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259394);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zxn != null) {
        paramVarArgs.g(1, this.Zxn);
      }
      if (this.Zxo != null) {
        paramVarArgs.g(2, this.Zxo);
      }
      paramVarArgs.bv(3, this.YVJ);
      paramVarArgs.e(4, 8, this.YSB);
      paramVarArgs.bS(5, this.YFu);
      if (this.Zxp != null) {
        paramVarArgs.g(6, this.Zxp);
      }
      if (this.YSF != null) {
        paramVarArgs.g(7, this.YSF);
      }
      if (this.YSJ != null) {
        paramVarArgs.g(8, this.YSJ);
      }
      paramVarArgs.e(9, 1, this.YVA);
      paramVarArgs.bS(10, this.YVB);
      if (this.Zxq != null) {
        paramVarArgs.g(11, this.Zxq);
      }
      if (this.Zxr != null) {
        paramVarArgs.g(12, this.Zxr);
      }
      AppMethodBeat.o(259394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zxn == null) {
        break label888;
      }
    }
    label888:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zxn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zxo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zxo);
      }
      i = i + i.a.a.b.b.a.q(3, this.YVJ) + i.a.a.a.c(4, 8, this.YSB) + i.a.a.b.b.a.cJ(5, this.YFu);
      paramInt = i;
      if (this.Zxp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zxp);
      }
      i = paramInt;
      if (this.YSF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YSF);
      }
      paramInt = i;
      if (this.YSJ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YSJ);
      }
      i = paramInt + i.a.a.a.c(9, 1, this.YVA) + i.a.a.b.b.a.cJ(10, this.YVB);
      paramInt = i;
      if (this.Zxq != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Zxq);
      }
      i = paramInt;
      if (this.Zxr != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Zxr);
      }
      AppMethodBeat.o(259394);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YSB.clear();
        this.YVA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apx localapx = (apx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259394);
          return -1;
        case 1: 
          localapx.Zxn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        case 2: 
          localapx.Zxo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        case 3: 
          localapx.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259394);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            qo localqo = new qo();
            if ((localObject != null) && (localObject.length > 0)) {
              localqo.parseFrom((byte[])localObject);
            }
            localapx.YSB.add(localqo);
            paramInt += 1;
          }
          AppMethodBeat.o(259394);
          return 0;
        case 5: 
          localapx.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259394);
          return 0;
        case 6: 
          localapx.Zxp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        case 7: 
          localapx.YSF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        case 8: 
          localapx.YSJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        case 9: 
          localapx.YVA.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(259394);
          return 0;
        case 10: 
          localapx.YVB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259394);
          return 0;
        case 11: 
          localapx.Zxq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259394);
          return 0;
        }
        localapx.Zxr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259394);
        return 0;
      }
      AppMethodBeat.o(259394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apx
 * JD-Core Version:    0.7.0.1
 */