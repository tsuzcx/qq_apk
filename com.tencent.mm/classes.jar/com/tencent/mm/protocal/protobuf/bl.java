package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.bx.a
{
  public String Ftq;
  public String Ftr;
  public String Fts;
  public String Ftt;
  public String Ftu;
  public String Ftv;
  public eiu Ftw;
  public String Ftx;
  public String gsT;
  public String ufY;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      if (this.Ftq != null) {
        paramVarArgs.d(2, this.Ftq);
      }
      if (this.Ftr != null) {
        paramVarArgs.d(3, this.Ftr);
      }
      if (this.ufY != null) {
        paramVarArgs.d(4, this.ufY);
      }
      if (this.uiR != null) {
        paramVarArgs.d(5, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(6, this.Fts);
      }
      if (this.Ftt != null) {
        paramVarArgs.d(7, this.Ftt);
      }
      if (this.Ftu != null) {
        paramVarArgs.d(8, this.Ftu);
      }
      if (this.Ftv != null) {
        paramVarArgs.d(9, this.Ftv);
      }
      if (this.Ftw != null)
      {
        paramVarArgs.lC(10, this.Ftw.computeSize());
        this.Ftw.writeFields(paramVarArgs);
      }
      if (this.Ftx != null) {
        paramVarArgs.d(11, this.Ftx);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label922;
      }
    }
    label922:
    for (int i = f.a.a.b.b.a.e(1, this.gsT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ftq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ftq);
      }
      i = paramInt;
      if (this.Ftr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ftr);
      }
      paramInt = i;
      if (this.ufY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufY);
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uiR);
      }
      paramInt = i;
      if (this.Fts != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fts);
      }
      i = paramInt;
      if (this.Ftt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ftt);
      }
      paramInt = i;
      if (this.Ftu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ftu);
      }
      i = paramInt;
      if (this.Ftv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ftv);
      }
      paramInt = i;
      if (this.Ftw != null) {
        paramInt = i + f.a.a.a.lB(10, this.Ftw.computeSize());
      }
      i = paramInt;
      if (this.Ftx != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Ftx);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbl.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbl.Ftq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbl.Ftr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbl.ufY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbl.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbl.Fts = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbl.Ftt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbl.Ftu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbl.Ftv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbl.Ftw = ((eiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbl.Ftx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */