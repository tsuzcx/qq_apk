package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fun
  extends com.tencent.mm.bx.a
{
  public int aaWG;
  public LinkedList<fuo> abSJ;
  public String abSK;
  public int abSL;
  public String abSM;
  public String abaT;
  public String appid;
  public int apptype;
  public String lym;
  public String nSt;
  
  public fun()
  {
    AppMethodBeat.i(74672);
    this.abSJ = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.nSt != null) {
        paramVarArgs.g(2, this.nSt);
      }
      paramVarArgs.bS(3, this.apptype);
      paramVarArgs.e(4, 8, this.abSJ);
      paramVarArgs.bS(5, this.aaWG);
      if (this.abSK != null) {
        paramVarArgs.g(6, this.abSK);
      }
      if (this.lym != null) {
        paramVarArgs.g(7, this.lym);
      }
      paramVarArgs.bS(8, this.abSL);
      if (this.abaT != null) {
        paramVarArgs.g(9, this.abaT);
      }
      if (this.abSM != null) {
        paramVarArgs.g(10, this.abSM);
      }
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nSt != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nSt);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.apptype) + i.a.a.a.c(4, 8, this.abSJ) + i.a.a.b.b.a.cJ(5, this.aaWG);
      paramInt = i;
      if (this.abSK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abSK);
      }
      i = paramInt;
      if (this.lym != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.lym);
      }
      i += i.a.a.b.b.a.cJ(8, this.abSL);
      paramInt = i;
      if (this.abaT != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abaT);
      }
      i = paramInt;
      if (this.abSM != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abSM);
      }
      AppMethodBeat.o(74673);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abSJ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fun localfun = (fun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localfun.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localfun.nSt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localfun.apptype = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fuo localfuo = new fuo();
            if ((localObject != null) && (localObject.length > 0)) {
              localfuo.parseFrom((byte[])localObject);
            }
            localfun.abSJ.add(localfuo);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localfun.aaWG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localfun.abSK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localfun.lym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 8: 
          localfun.abSL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74673);
          return 0;
        case 9: 
          localfun.abaT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localfun.abSM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fun
 * JD-Core Version:    0.7.0.1
 */