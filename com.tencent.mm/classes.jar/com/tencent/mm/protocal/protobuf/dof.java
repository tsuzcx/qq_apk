package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dof
  extends com.tencent.mm.bx.a
{
  public etl ZpX;
  public etl ZpY;
  public int Zpe;
  public etl ZqQ;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public int aaVf;
  public etl aaVg;
  public etl aaVh;
  public etl aaVi;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public int pSj;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.aaVg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.aaVh == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.aaVi == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.ZqQ != null)
      {
        paramVarArgs.qD(1, this.ZqQ.computeSize());
        this.ZqQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaVf);
      if (this.aaIz != null)
      {
        paramVarArgs.qD(3, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      if (this.ZpX != null)
      {
        paramVarArgs.qD(4, this.ZpX.computeSize());
        this.ZpX.writeFields(paramVarArgs);
      }
      if (this.ZpY != null)
      {
        paramVarArgs.qD(5, this.ZpY.computeSize());
        this.ZpY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.pSf);
      if (this.aaVg != null)
      {
        paramVarArgs.qD(9, this.aaVg.computeSize());
        this.aaVg.writeFields(paramVarArgs);
      }
      if (this.aaVh != null)
      {
        paramVarArgs.qD(10, this.aaVh.computeSize());
        this.aaVh.writeFields(paramVarArgs);
      }
      if (this.aaVi != null)
      {
        paramVarArgs.qD(11, this.aaVi.computeSize());
        this.aaVi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.Zpe);
      if (this.pSg != null) {
        paramVarArgs.g(13, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(14, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(15, this.pSi);
      }
      paramVarArgs.bS(16, this.pSj);
      paramVarArgs.bS(17, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(18, this.aaMn);
      }
      if (this.pSo != null) {
        paramVarArgs.g(19, this.pSo);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqQ == null) {
        break label1964;
      }
    }
    label1964:
    for (paramInt = i.a.a.a.qC(1, this.ZqQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaVf);
      paramInt = i;
      if (this.aaIz != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaIz.computeSize());
      }
      i = paramInt;
      if (this.ZpX != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZpX.computeSize());
      }
      paramInt = i;
      if (this.ZpY != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZpY.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.pSf);
      paramInt = i;
      if (this.aaVg != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaVg.computeSize());
      }
      i = paramInt;
      if (this.aaVh != null) {
        i = paramInt + i.a.a.a.qC(10, this.aaVh.computeSize());
      }
      paramInt = i;
      if (this.aaVi != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaVi.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Zpe);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.pSj) + i.a.a.b.b.a.cJ(17, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aaMn);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.pSo);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.aaVg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.aaVh == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.aaVi == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dof localdof = (dof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        etl localetl;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.ZqQ = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localdof.aaVf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.aaIz = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.ZpX = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.ZpY = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localdof.pSf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.aaVg = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.aaVh = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdof.aaVi = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localdof.Zpe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localdof.pSg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localdof.pSh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localdof.pSi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localdof.pSj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localdof.aaMm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localdof.aaMn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localdof.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dof
 * JD-Core Version:    0.7.0.1
 */