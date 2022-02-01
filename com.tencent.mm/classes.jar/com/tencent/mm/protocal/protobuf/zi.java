package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zi
  extends dyl
{
  public String CqK;
  public int RIv;
  public String RQH;
  public bd Sdp;
  public String SkB;
  public String SlA;
  public String SlB;
  public int SlC;
  public String SlD;
  public int SlE;
  public String SlF;
  public String Sly;
  public String Slz;
  public String UserName;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.Sly != null) {
        paramVarArgs.f(3, this.Sly);
      }
      if (this.RQH != null) {
        paramVarArgs.f(4, this.RQH);
      }
      if (this.Slz != null) {
        paramVarArgs.f(5, this.Slz);
      }
      if (this.SlA != null) {
        paramVarArgs.f(6, this.SlA);
      }
      if (this.SlB != null) {
        paramVarArgs.f(7, this.SlB);
      }
      if (this.SkB != null) {
        paramVarArgs.f(8, this.SkB);
      }
      paramVarArgs.aY(9, this.SlC);
      if (this.Sdp != null)
      {
        paramVarArgs.oE(10, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      if (this.SlD != null) {
        paramVarArgs.f(11, this.SlD);
      }
      if (this.UserName != null) {
        paramVarArgs.f(12, this.UserName);
      }
      if (this.CqK != null) {
        paramVarArgs.f(13, this.CqK);
      }
      paramVarArgs.aY(14, this.RIv);
      paramVarArgs.aY(15, this.SlE);
      if (this.SlF != null) {
        paramVarArgs.f(16, this.SlF);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.Sly != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sly);
      }
      paramInt = i;
      if (this.RQH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RQH);
      }
      i = paramInt;
      if (this.Slz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Slz);
      }
      paramInt = i;
      if (this.SlA != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SlA);
      }
      i = paramInt;
      if (this.SlB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SlB);
      }
      paramInt = i;
      if (this.SkB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SkB);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.SlC);
      paramInt = i;
      if (this.Sdp != null) {
        paramInt = i + g.a.a.a.oD(10, this.Sdp.computeSize());
      }
      i = paramInt;
      if (this.SlD != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SlD);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UserName);
      }
      i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.CqK);
      }
      i = i + g.a.a.b.b.a.bM(14, this.RIv) + g.a.a.b.b.a.bM(15, this.SlE);
      paramInt = i;
      if (this.SlF != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.SlF);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zi localzi = (zi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
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
            localzi.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localzi.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localzi.Sly = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localzi.RQH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localzi.Slz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localzi.SlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localzi.SlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localzi.SkB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localzi.SlC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91416);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bd)localObject2).parseFrom((byte[])localObject1);
            }
            localzi.Sdp = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localzi.SlD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localzi.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localzi.CqK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localzi.RIv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localzi.SlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91416);
          return 0;
        }
        localzi.SlF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zi
 * JD-Core Version:    0.7.0.1
 */