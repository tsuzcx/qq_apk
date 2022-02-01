package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chv
  extends com.tencent.mm.bx.a
{
  public String Edm;
  public double Edn;
  public LinkedList<rt> Edo;
  public String Edp;
  public LinkedList<clo> Edq;
  public long bTj;
  public String dlB;
  public String nickname;
  public String username;
  public String uwS;
  
  public chv()
  {
    AppMethodBeat.i(50103);
    this.Edo = new LinkedList();
    this.Edq = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.uwS != null) {
        paramVarArgs.d(4, this.uwS);
      }
      paramVarArgs.aG(5, this.bTj);
      if (this.Edm != null) {
        paramVarArgs.d(6, this.Edm);
      }
      paramVarArgs.e(7, this.Edn);
      paramVarArgs.e(16, 8, this.Edo);
      if (this.Edp != null) {
        paramVarArgs.d(17, this.Edp);
      }
      paramVarArgs.e(19, 8, this.Edq);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label929;
      }
    }
    label929:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.uwS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uwS);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.bTj);
      paramInt = i;
      if (this.Edm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Edm);
      }
      i = paramInt + (f.a.a.b.b.a.fY(7) + 8) + f.a.a.a.c(16, 8, this.Edo);
      paramInt = i;
      if (this.Edp != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Edp);
      }
      i = f.a.a.a.c(19, 8, this.Edq);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Edo.clear();
        this.Edq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chv localchv = (chv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(50104);
          return -1;
        case 1: 
          localchv.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localchv.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localchv.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localchv.uwS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localchv.bTj = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localchv.Edm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localchv.Edn = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchv.Edo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localchv.Edp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchv.Edq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      AppMethodBeat.o(50104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chv
 * JD-Core Version:    0.7.0.1
 */