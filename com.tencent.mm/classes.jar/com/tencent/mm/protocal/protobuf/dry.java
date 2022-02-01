package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public class dry
  extends com.tencent.mm.bx.a
{
  public long AxK;
  public String aaXF;
  public dru aaXG;
  public drs aaXH;
  public drw aaXI;
  public drx aaXJ;
  public boolean aaXK;
  public drv aaXL;
  public drv aaXM;
  public drv aaXN;
  public String aaXn;
  public int itemType;
  public String zIO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260015);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "contextId", this.zIO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "enterTimestamp", Long.valueOf(this.AxK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemId", this.aaXF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemType", Integer.valueOf(this.itemType), false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemSubId", this.aaXn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "browseReportData", this.aaXG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "addReportData", this.aaXH, false);
      com.tencent.mm.bk.a.a(localJSONObject, "pageActionData", this.aaXI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "performanceData", this.aaXJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isEnterChatting", Boolean.valueOf(this.aaXK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "eduAddReportData", this.aaXL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "eduEnterReportData", this.aaXM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "eduListReportData", this.aaXN, false);
      label165:
      AppMethodBeat.o(260015);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260031);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zIO != null) {
        paramVarArgs.g(1, this.zIO);
      }
      paramVarArgs.bv(2, this.AxK);
      if (this.aaXF != null) {
        paramVarArgs.g(3, this.aaXF);
      }
      paramVarArgs.bS(4, this.itemType);
      if (this.aaXn != null) {
        paramVarArgs.g(5, this.aaXn);
      }
      if (this.aaXG != null)
      {
        paramVarArgs.qD(6, this.aaXG.computeSize());
        this.aaXG.writeFields(paramVarArgs);
      }
      if (this.aaXH != null)
      {
        paramVarArgs.qD(7, this.aaXH.computeSize());
        this.aaXH.writeFields(paramVarArgs);
      }
      if (this.aaXI != null)
      {
        paramVarArgs.qD(8, this.aaXI.computeSize());
        this.aaXI.writeFields(paramVarArgs);
      }
      if (this.aaXJ != null)
      {
        paramVarArgs.qD(9, this.aaXJ.computeSize());
        this.aaXJ.writeFields(paramVarArgs);
      }
      paramVarArgs.di(10, this.aaXK);
      if (this.aaXL != null)
      {
        paramVarArgs.qD(11, this.aaXL.computeSize());
        this.aaXL.writeFields(paramVarArgs);
      }
      if (this.aaXM != null)
      {
        paramVarArgs.qD(12, this.aaXM.computeSize());
        this.aaXM.writeFields(paramVarArgs);
      }
      if (this.aaXN != null)
      {
        paramVarArgs.qD(13, this.aaXN.computeSize());
        this.aaXN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zIO == null) {
        break label1404;
      }
    }
    label1404:
    for (paramInt = i.a.a.b.b.a.h(1, this.zIO) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.AxK);
      paramInt = i;
      if (this.aaXF != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaXF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.itemType);
      paramInt = i;
      if (this.aaXn != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaXn);
      }
      i = paramInt;
      if (this.aaXG != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaXG.computeSize());
      }
      paramInt = i;
      if (this.aaXH != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaXH.computeSize());
      }
      i = paramInt;
      if (this.aaXI != null) {
        i = paramInt + i.a.a.a.qC(8, this.aaXI.computeSize());
      }
      paramInt = i;
      if (this.aaXJ != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaXJ.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 1);
      paramInt = i;
      if (this.aaXL != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaXL.computeSize());
      }
      i = paramInt;
      if (this.aaXM != null) {
        i = paramInt + i.a.a.a.qC(12, this.aaXM.computeSize());
      }
      paramInt = i;
      if (this.aaXN != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaXN.computeSize());
      }
      AppMethodBeat.o(260031);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dry localdry = (dry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260031);
          return -1;
        case 1: 
          localdry.zIO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260031);
          return 0;
        case 2: 
          localdry.AxK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260031);
          return 0;
        case 3: 
          localdry.aaXF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260031);
          return 0;
        case 4: 
          localdry.itemType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260031);
          return 0;
        case 5: 
          localdry.aaXn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260031);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dru();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dru)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXG = ((dru)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drs)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXH = ((drs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drw)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXI = ((drw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drx)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXJ = ((drx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        case 10: 
          localdry.aaXK = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(260031);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drv)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXL = ((drv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new drv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((drv)localObject2).parseFrom((byte[])localObject1);
            }
            localdry.aaXM = ((drv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260031);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new drv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((drv)localObject2).parseFrom((byte[])localObject1);
          }
          localdry.aaXN = ((drv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260031);
        return 0;
      }
      AppMethodBeat.o(260031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dry
 * JD-Core Version:    0.7.0.1
 */