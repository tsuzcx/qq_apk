package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ekn
  extends dyl
{
  public LinkedList<eaf> BlackList;
  public int BlackListCount;
  public int GroupCount;
  public LinkedList<eaf> GroupUser;
  public int GroupUserCount;
  public eae ObjectDesc;
  public eae RMM;
  public eae RMN;
  public long ReferId;
  public ekr SnsRedEnvelops;
  public int TEb;
  public LinkedList<ejw> TEh;
  public ekm TEm;
  public evb TUs;
  public int Uml;
  public int Umm;
  public int Umn;
  public ekl Umo;
  public eae Ump;
  public String Umq;
  public tv Umr;
  public int Ums;
  public LinkedList<cvr> Umt;
  public ejk Umu;
  public dgj Umv;
  public LinkedList<eaf> WithUserList;
  public int WithUserListCount;
  public String lps;
  
  public ekn()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.TEh = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.Umt = new LinkedList();
    AppMethodBeat.o(125805);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125806);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.oE(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aY(5, this.Uml);
      paramVarArgs.aY(6, this.TEb);
      if (this.lps != null) {
        paramVarArgs.f(7, this.lps);
      }
      paramVarArgs.aY(8, this.Umm);
      paramVarArgs.aY(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.TEh);
      paramVarArgs.aY(11, this.Umn);
      paramVarArgs.bm(12, this.ReferId);
      paramVarArgs.aY(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.TUs != null)
      {
        paramVarArgs.oE(15, this.TUs.computeSize());
        this.TUs.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.Umo != null)
      {
        paramVarArgs.oE(18, this.Umo.computeSize());
        this.Umo.writeFields(paramVarArgs);
      }
      if (this.TEm != null)
      {
        paramVarArgs.oE(19, this.TEm.computeSize());
        this.TEm.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.oE(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.Ump != null)
      {
        paramVarArgs.oE(21, this.Ump.computeSize());
        this.Ump.writeFields(paramVarArgs);
      }
      if (this.Umq != null) {
        paramVarArgs.f(22, this.Umq);
      }
      if (this.Umr != null)
      {
        paramVarArgs.oE(23, this.Umr.computeSize());
        this.Umr.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(24, this.Ums);
      paramVarArgs.e(25, 8, this.Umt);
      if (this.Umu != null)
      {
        paramVarArgs.oE(26, this.Umu.computeSize());
        this.Umu.writeFields(paramVarArgs);
      }
      if (this.RMM != null)
      {
        paramVarArgs.oE(27, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(28, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      if (this.Umv != null)
      {
        paramVarArgs.oE(29, this.Umv.computeSize());
        this.Umv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2960;
      }
    }
    label2960:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + g.a.a.a.oD(2, this.ObjectDesc.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.WithUserListCount) + g.a.a.a.c(4, 8, this.WithUserList) + g.a.a.b.b.a.bM(5, this.Uml) + g.a.a.b.b.a.bM(6, this.TEb);
      paramInt = i;
      if (this.lps != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lps);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Umm) + g.a.a.b.b.a.bM(9, this.GroupCount) + g.a.a.a.c(10, 8, this.TEh) + g.a.a.b.b.a.bM(11, this.Umn) + g.a.a.b.b.a.p(12, this.ReferId) + g.a.a.b.b.a.bM(13, this.BlackListCount) + g.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.TUs != null) {
        paramInt = i + g.a.a.a.oD(15, this.TUs.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.GroupUserCount) + g.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.Umo != null) {
        paramInt = i + g.a.a.a.oD(18, this.Umo.computeSize());
      }
      i = paramInt;
      if (this.TEm != null) {
        i = paramInt + g.a.a.a.oD(19, this.TEm.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + g.a.a.a.oD(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.Ump != null) {
        i = paramInt + g.a.a.a.oD(21, this.Ump.computeSize());
      }
      paramInt = i;
      if (this.Umq != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.Umq);
      }
      i = paramInt;
      if (this.Umr != null) {
        i = paramInt + g.a.a.a.oD(23, this.Umr.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(24, this.Ums) + g.a.a.a.c(25, 8, this.Umt);
      paramInt = i;
      if (this.Umu != null) {
        paramInt = i + g.a.a.a.oD(26, this.Umu.computeSize());
      }
      i = paramInt;
      if (this.RMM != null) {
        i = paramInt + g.a.a.a.oD(27, this.RMM.computeSize());
      }
      paramInt = i;
      if (this.RMN != null) {
        paramInt = i + g.a.a.a.oD(28, this.RMN.computeSize());
      }
      i = paramInt;
      if (this.Umv != null) {
        i = paramInt + g.a.a.a.oD(29, this.Umv.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.TEh.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.Umt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ObjectDesc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjectDesc");
          AppMethodBeat.o(125806);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekn localekn = (ekn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localekn.ObjectDesc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localekn.WithUserListCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localekn.WithUserList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localekn.Uml = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localekn.TEb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localekn.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localekn.Umm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localekn.GroupCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejw)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.TEh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localekn.Umn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localekn.ReferId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localekn.BlackListCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localekn.BlackList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evb)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.TUs = ((evb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localekn.GroupUserCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localekn.GroupUser.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekl)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.Umo = ((ekl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekm)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.TEm = ((ekm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekr)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.SnsRedEnvelops = ((ekr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localekn.Ump = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localekn.Umq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tv)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.Umr = ((tv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localekn.Ums = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvr)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.Umt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejk)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.Umu = ((ejk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localekn.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localekn.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dgj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dgj)localObject2).parseFrom((byte[])localObject1);
          }
          localekn.Umv = ((dgj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125806);
        return 0;
      }
      AppMethodBeat.o(125806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekn
 * JD-Core Version:    0.7.0.1
 */